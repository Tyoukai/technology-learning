package java8.reflcet;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-21
 */
public class ReflectTest {
    public static void main(String[] args) {
        run run = new Cat();
        System.out.println(run.getClass());

        run.dogRun();
    }
}
