import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java8.Person;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-15
 */
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "1"));
        list.add(new Person(2, "2"));

        List<Person> list1 = new ArrayList<>(list);

        System.out.println(list.get(0) == list1.get(0));
    }
}
