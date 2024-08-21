package jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @Author: Tyoukai
 * @Date: 2024/8/21 14:59
 */
public class JolDemo {
    public static void main(String[] args) {
        String a = "222222";
        // 打印对象的布局信息
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        // 打印对象的retained size，即对象及其引用的对象的大小，单位byte
        System.out.println(GraphLayout.parseInstance(a).totalSize());
    }
}
