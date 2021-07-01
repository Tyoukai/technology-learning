package grpc.client;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

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
public class ZkNameResolver extends NameResolver implements Watcher {
    // zk的地址
    private URI zkUri;

    // zk上放置指定服务的地址
    private String grpcServerUrlPathInZk = "/grpc_server_url";

    // zk连接
    private ZooKeeper zookeeper;

    private final int ZK_CONN_TIMEOUT = 3000;

    private Listener listener;

    ZkNameResolver(URI zkUri) {
        this.zkUri = zkUri;
    }

    @Override
    public String getServiceAuthority() {
        return null;
    }

    @Override
    public void shutdown() {
        try {
            zookeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Listener listener) {
        this.listener = listener;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        String zkAddress = zkUri.getHost() + ":" + zkUri.getPort();
        try {
            zookeeper = new ZooKeeper(zkAddress, ZK_CONN_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getState() == KeeperState.SyncConnected) {
                        countDownLatch.countDown();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("连接zookeeper出错");
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            List<String> servers = zookeeper.getChildren(grpcServerUrlPathInZk, this);
            addServersToListener(servers);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == EventType.None) {
            System.out.println("连接断开");
        } else {
            try {
                List<String> servers = zookeeper.getChildren(grpcServerUrlPathInZk, this);
                addServersToListener(servers);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
