package java8.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: Tyoukai
 * @Date: 2023/9/26 14:29
 */
public class MapToLongTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "aa", "aaa", "aaaa");
        IntStream stream = list.stream().mapToInt(String::length);
//        System.out.println(stream.sum());
        stream.forEach(System.out::println);
    }
}
