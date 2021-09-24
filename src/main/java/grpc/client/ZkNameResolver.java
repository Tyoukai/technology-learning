package grpc.client;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-26
 */
public class ZkNameResolver extends NameResolver {
    // zk的地址
    private URI zkUri;

    // zk上放置指定服务的地址
    private static String GRPC_SERVER_PATH = "/grpc/server";

    private CuratorFramework curatorClient;

    private final int ZK_CONN_TIMEOUT = 3000;

    private Listener listener;

    ZkNameResolver(URI zkUri) {
        this.zkUri = zkUri;
    }

    @Override
    public String getServiceAuthority() {
        return "none";
    }

    @Override
    public void shutdown() {
        curatorClient.close();
    }

    @Override
    public void start(Listener listener) {
        this.listener = listener;

        curatorClient = CuratorFrameworkFactory.builder()
                .connectString(zkUri.getPath().substring(1))
                .connectionTimeoutMs(ZK_CONN_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        curatorClient.start();

        PathChildrenCache cache = new PathChildrenCache(curatorClient, GRPC_SERVER_PATH, true);
        cache.getListenable().addListener((curatorFramework, event) -> {
            ChildData childData = event.getData();
            System.out.println(new String(childData.getData()));
            switch (event.getType()) {
                case CHILD_REMOVED:
                case CHILD_ADDED:
                case CHILD_UPDATED:
                    System.out.println("data change");
            }
        });

        try {
            cache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
            List<String> servers = curatorClient.getChildren().forPath(GRPC_SERVER_PATH);
            addServersToListener(servers);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addServersToListener (List<String> servers) {
        List<EquivalentAddressGroup> addressGroups = new ArrayList<>();
        for (String server : servers) {
            List<SocketAddress> socketAddresses = new ArrayList<>();
            String[] address = server.split(":");
            socketAddresses.add(new InetSocketAddress(address[0], Integer.parseInt(address[1])));
            addressGroups.add(new EquivalentAddressGroup(socketAddresses));
        }
        listener.onAddresses(addressGroups, Attributes.EMPTY);
    }
}
