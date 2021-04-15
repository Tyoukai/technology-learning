package guava;

import com.google.common.base.CaseFormat;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-13
 */
public class CaseFormatTest {
    public static void main(String[] args) {
        String s = "testNameForJava";
        String lower_underscore = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, s);
        System.out.println(lower_underscore);

        String lower_camel = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, lower_underscore);
        System.out.println(lower_camel);
    }
}
