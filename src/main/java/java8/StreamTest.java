package java8;

import java.util.stream.IntStream;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-03-29
 */
public class StreamTest {
    public static void main(String[] args) {
        StreamTest test = new StreamTest();
        test.cycle();

    }

    public void cycle() {
        IntStream.range(0, 100).forEach(this::test);
    }

    public void test(int i) {
        System.out.println(i);
    }
}
