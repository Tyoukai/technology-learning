package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-27
 */
public class CollectorsToMapTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "11"));
        list.add(new Person(2, "22"));
        list.add(new Person(3, "33"));
        list.add(new Person(3, "44"));


        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getAge, Person::getName, (a, b) -> b));
        System.out.println(map);

        map = list.stream().collect(Collectors.toMap(Person::getAge, Person::getName));

        System.out.println(map);
    }

}
