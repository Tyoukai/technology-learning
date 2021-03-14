package java8;

import java.util.Optional;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-03-14
 */
public class NewFeatrueInJava8Test {

    public static void main(String[] args) {
        try {
            testOptional();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
