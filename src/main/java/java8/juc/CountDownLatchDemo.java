package java8.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Tyoukai
 * @Date: 2023/6/12 10:18
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
               System.out.println("任务" + Thread.currentThread().getName() + "开始执行");
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                countDownLatch.countDown();

                System.out.println("任务" + Thread.currentThread().getName() + "执行结束");
            });
        }

        System.out.println("主程序等待任务执行");
        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("主程序执行完成");
    }
}
