package java8.reflcet;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-21
 */
public interface run {

    default void dogRun() {
        System.out.println(this.getClass());
        System.out.println("dogRun");
    }

    String catRun();

}
