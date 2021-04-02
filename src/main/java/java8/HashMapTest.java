package java8;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-03-13
 */
public class HashMapTest {


    public static void main(String[] args) {
//        computeIfAbsentTest();
        consumerTest();
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


