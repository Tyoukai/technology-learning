package java8;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-03-13
 */
public class MapTest {


    public static void main(String[] args) {
//        computeIfAbsentTest();
//        consumerTest();
        multiMapTest();
    }

    public static void multiMapTest() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "zkw");
        map.add("name", "tom");
        map.add("name", "Bob");

        map.add("age", "18");
        map.add("age", "30");
        map.add("age", "29");

        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        System.out.println(map.getFirst("name"));
        System.out.println(map.getFirst("age"));
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

    public static void consumerTest() {
        Consumer<Integer> consumer1 = x -> System.out.println("当前值：" + x);

        Consumer<Integer> consumer2 = x -> {System.out.println("相加值：" + (x + x));};

        Consumer<Integer> consumer3 = x -> System.out.println("相乘：" + (x * x));

        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
    }

}


