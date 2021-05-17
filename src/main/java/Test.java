import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-15
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<String> list1 = new ArrayList<>(list);
//        list1.stream().filter(str -> {
//            return str.equals("1");
//        }).collect(Collectors.toList());
        list1.remove("2");
        String a = String.valueOf(123L);
        System.out.println(a);

        System.out.println(list);
        System.out.println(list1);
    }
}
