package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-03-14
 */
public class NewFeatrueInJava8Test {

    public static void main(String[] args) {
//        try {
//            testOptional();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        testFunctional();
    }

    public static void testOptional() throws Exception {
        String result = "null";
        Optional<String> strOptional = Optional.ofNullable(result);

        System.out.println(strOptional.isPresent());

        strOptional.ifPresent(str -> System.out.println(str));

        String str = Optional.ofNullable(result).orElse("1");

        System.out.println("orElse:" + str);

        String str1 = Optional.ofNullable(result).orElseGet(() -> {
            System.out.print("orElseGet:");
            return "2";
        });

        System.out.print(str1);
        System.out.println();

//        String str2 = Optional.ofNullable(result).orElseThrow(() -> {
//           System.out.print("orElseThrow:");
//           return new Exception("null");
//        });


        String str3 = Optional.ofNullable(result)
                            .map(tmp -> tmp = "sd")
                            .map(tmp -> tmp = "112")
                            .orElse("unKnow");
        System.out.println("map:" + str3);


        Optional<String> strOptional1 = Optional.ofNullable(result)
                            .flatMap(tmp -> Optional.of("123"));
        strOptional1.ifPresent(tmp -> System.out.println("flatMap:" + tmp));
    }

    public static void testFunctional() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        addAndPrint(list, list1 -> {
            int sum = 0;
            for (int i = 0; i < list1.size(); i++) {
                sum += list1.get(i);
            }

            System.out.println(sum);
        });
    }

    public static void addAndPrint(List<Integer> list, Consumer<List<Integer>> consumer) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + 1);
        }

        consumer.accept(list);
    }
}
