package java8.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Tyoukai
 * @Date: 2023/11/30 9:41
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2023.11.10");
        list.add("2023.11.11");
        list.add("2023.11.12");

        list.remove(0);
        System.out.println(list);
    }
}
