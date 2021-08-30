package zookeeper;

import java.util.List;

public class ZookeeperDemo {
    public static void main(String[] args) throws Exception {
        BaseZookeeper zookeeper = new BaseZookeeper();
        zookeeper.connectZookeeper("42.192.49.234:2181");

        List<String> children = zookeeper.getChildren("/");
        System.out.println(children);
    }
}
