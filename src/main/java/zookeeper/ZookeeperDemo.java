package zookeeper;

import java.util.List;

public class ZookeeperDemo {
    public static void main(String[] args) throws Exception {
        BaseZookeeper zookeeper = new BaseZookeeper();
        zookeeper.connectZookeeper("42.192.49.234:2181");

        zookeeper.setData("/gateway/zookeeper_test", "[{\"route_id\":\"zookeeper_test\",\"route_definition\":{\"id\":\"zookeeper_test\",\"predicates\":[{\"name\":\"Path\",\"args\":{\"_genkey_0\":\"/zookeeper_test\"}}],\"filters\":[],\"uri\":\"https://www.bilibili.com/\",\"order\":0},\"order\":0}]");

        zookeeper.setData("/test", "1111");
        List<String> children = zookeeper.getChildren("/");
        System.out.println(children);
    }
}
