package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorDemo {
    private static String path = "/curator";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("172.16.125.224:2181")  // 42.192.49.234:2181
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(10000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();

        client.start();

        // 创建节点
//        client.create().forPath("/curator333", "".getBytes());

//        client.delete().forPath("/curator333");
        // 查询节点
//        byte[] data = client.getData().forPath("/curator");
//        System.out.println(new String(data));

        // 更新节点
//        client.setData().forPath("/curator", "newTest".getBytes());
//
//        data = client.getData().forPath("/curator");
//        System.out.println(new String(data));

        client.create().withMode(CreateMode.EPHEMERAL).forPath("/dailyProcessCheckLock", "".getBytes());

        client.delete().forPath("/dailyProcessCheckLock");

        System.out.println(client.getChildren().forPath(path));


        PathChildrenCache cache = new PathChildrenCache(client, path, true);

        PathChildrenCacheListener listener = (curatorFramework, event) -> {
            ChildData data = event.getData();
            String strData = new String(data.getData());
            switch (event.getType()) {
                case CHILD_ADDED:
                    System.out.println("子节点创建,路径：" + data.getPath() + ", 节点数据：" + strData);
                    break;
                case CHILD_UPDATED:
                    System.out.println("子节点数据更新，路径：" + data.getPath() + ",节点数据：" + strData);
                    break;
                case CHILD_REMOVED:
                    System.out.println("子节点被移除，路径：" + data.getPath() + ",节点数据：" + strData);
            }
        };

        cache.getListenable().addListener(listener);
        cache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);

        while (true) {
            Thread.sleep(1000);
        }

    }
}
