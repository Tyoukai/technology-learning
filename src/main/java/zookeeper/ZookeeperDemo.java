package zookeeper;

import java.util.List;

public class ZookeeperDemo {
    public static void main(String[] args) throws Exception {
        BaseZookeeper zookeeper = new BaseZookeeper();
        zookeeper.connectZookeeper("42.192.49.234:2181");

        zookeeper.setData("/gateway/dynamic_route1", "{\"id\":\"dynamic_route1\",\"predicates\":[{\"name\":\"Path\",\"args\":{\"_genkey_0\":\"/dynamic_route1\"}}],\"filters\":[],\"uri\":\"https://www.baidu.com/\",\"order\":0}");

        zookeeper.setData("/test", "1111");
        List<String> children = zookeeper.getChildren("/");
        System.out.println(children);
    }
}
