package java8.lambda;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: Tyoukai
 * @Date: 2023/6/14 13:42
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = str -> str.startsWith("A");
        Predicate<String> predicate1 = str -> str.length() < 4;

        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");

        System.out.println(names.stream().filter(predicate).collect(Collectors.toList()));
        System.out.println(names.stream().filter(predicate.and(predicate1)).collect(Collectors.toList()));
        System.out.println(names.stream().filter(predicate.or(predicate1)).collect(Collectors.toList()));
        System.out.println(names.stream().filter(predicate.or(predicate1.negate())).collect(Collectors.toList()));


        DateTime dateTime = DateUtil.parse("2024-07-09 10:14:34", "yyyy-MM-dd HH:mm:ss");
        DateTime b = dateTime.offset(DateField.MINUTE, 10);
        System.out.println(dateTime);
        System.out.println(b);

    }
}
