package java8;

import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Tyoukai
 * @Date: 2024/4/30 13:59
 */
public class GroupByTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "zhangsan"));
        personList.add(new Person(1, "zhangsan"));
        personList.add(new Person(2, "zhangsan"));
        personList.add(new Person(1, "lisi"));
        personList.add(new Person(2, "lisi"));
        personList.add(new Person(1, "wangwu"));
        personList.add(new Person(2, "wangwu"));
        personList.add(new Person(3, "wangwu"));

        Map<Integer, List<Person>> groupByAge = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupByAge);

        Map<Integer, Map<String, List<Person>>> groupByAgeAndName = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(Person::getName)));
        System.out.println(groupByAgeAndName);
    }
}
