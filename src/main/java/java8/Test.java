package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-27
 */
public class Test {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", "2");
//        map.put("3", "3");
//
//        System.out.println(map);
//
//        map.values().removeIf(item -> "3".equals(item));
//
//        System.out.println(map);
//        int a = 1_048_576;
//        System.out.println(a);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(String.join(",", list));

    }
}
