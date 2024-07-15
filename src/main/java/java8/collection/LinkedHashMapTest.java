package java8.collection;

import jackjson.ObjectMapperUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/22 9:20
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        System.out.println(map);

    }
}
