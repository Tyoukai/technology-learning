package java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-01
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread");
            } catch (Exception e) {
            }
        });

        service.shutdown();
    }
}
