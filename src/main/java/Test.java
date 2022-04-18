import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import java8.Person;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-15
 */
public class Test {
    public static void main(String[] args) {
//        List<Person> list = new ArrayList<>();
//        list.add(new Person(1, "1"));
//        list.add(new Person(2, "2"));
//
//        List<Person> list1 = new ArrayList<>(list);
//
//        System.out.println(list.get(0) == list1.get(0));
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("string", "string");
//        map.put("int", 1);
//
//        System.out.println(map.get("int") instanceof String);

        long i = 1639285148;
        long t = i + 3800;

        for (; i< t; i++ ) {
            System.out.println(i / 3600);
        }

        int[][] a = new int[4][3];
        Arrays.sort(a, (int[] m, int[] n) -> m[0] - n[0]);
    }
}
