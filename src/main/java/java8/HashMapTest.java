package java8;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-03-13
 */
public class HashMapTest {


    public static void main(String[] args) {
        computeIfAbsentTest();
    }

    public static void computeIfAbsentTest() {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        System.out.println(map.toString());

        map.computeIfAbsent("3", k -> "4");

        map.computeIfAbsent("4", k -> {
            return "4";
        });


        System.out.println(map);

    }

}


