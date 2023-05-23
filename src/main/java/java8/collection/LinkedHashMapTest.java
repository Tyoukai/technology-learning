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
        String format1 = "{\"name\":\"cpu_usage2\",\"nameOrigin\":\"10982\",\"nameShow\":\"机器2CPU使用率\",\"value\":\"710.933\"}";
        String format2 = "{\n" +
                "  \"name\" : \"doc_count\",\n" +
                "  \"nameOrigin\" : \"1\",\n" +
                "  \"nameShow\" : \"文档总数\",\n" +
                "  \"value\" : {\n" +
                "    \"TOTALCOUNT\" : \"5806\"\n" +
                "  }\n" +
                "}";

        Map<Object, Object> map = ObjectMapperUtil.fromJson(format1, Map.class);
        Object o1 = map.get("value");
        Map<String, String> map2 = ObjectMapperUtil.fromJson(format2, Map.class);
        Object o2 = map2.get("value");

        Map<String, String> test = new HashMap<>();
        test.put("1", "1");
        test.put("2", "2");
        System.out.println(ObjectMapperUtil.toJson(test));

        System.out.println(ObjectMapperUtil.toJson(o2));
    }
}
