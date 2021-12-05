package java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-27
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        System.out.println(map);

        map.values().removeIf(item -> "3".equals(item));

        System.out.println(map);
    }
}
