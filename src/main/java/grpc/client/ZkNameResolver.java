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

    private String serviceName;

    // zk上放置指定服务的地址
    private static String GRPC_SERVER_PATH = "/grpc/server/";

    private CuratorFramework curatorClient;

    private  PathChildrenCache cache;

    private final int ZK_CONN_TIMEOUT = 3000;

    private Listener listener;

    ZkNameResolver(URI zkUri, String serviceName) {
        this.zkUri = zkUri;
        this.serviceName = serviceName;
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
                .connectString(zkUri.getHost() + ":" + zkUri.getPort())
                .connectionTimeoutMs(ZK_CONN_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        curatorClient.start();

        cache = new PathChildrenCache(curatorClient, packagingService(), true);
        cache.getListenable().addListener((curatorFramework, event) -> {
            ChildData childData = event.getData();

            switch (event.getType()) {
                case CHILD_REMOVED:
                    System.out.println("delete");
                    addServersToListener();
                    break;
                case CHILD_ADDED:
                case CHILD_UPDATED:
                    addServersToListener();
                    System.out.println(new String(childData.getData()));
            }
        });

        try {
            cache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
            addServersToListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addServersToListener() throws Exception {
        List<String> servers = curatorClient.getChildren().forPath(packagingService());
        List<EquivalentAddressGroup> addressGroups = new ArrayList<>();
        for (String server : servers) {
            List<SocketAddress> socketAddresses = new ArrayList<>();
            String[] address = server.split(":");
            socketAddresses.add(new InetSocketAddress(address[0], Integer.parseInt(address[1])));
            addressGroups.add(new EquivalentAddressGroup(socketAddresses));
        }
        listener.onAddresses(addressGroups, Attributes.EMPTY);
    }

    private String packagingService() {
        StringBuffer sb = new StringBuffer();
        sb.append(GRPC_SERVER_PATH).append(serviceName);
        return sb.toString();
    }
}
