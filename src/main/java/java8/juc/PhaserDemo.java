package java8.juc;

import java.util.concurrent.*;

/**
 * @Author: Tyoukai
 * @Date: 2023/6/12 13:55
 */
public class PhaserDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Phaser phaser = new Phaser();
        phaser.register();

        for (int i = 0; i < 3; i++) {
            phaser.register();
            executorService.submit(() -> {


                System.out.println("任务" + Thread.currentThread().getName() + "准备完毕，即将开始执行任务");
                phaser.arriveAndAwaitAdvance();

                System.out.println("任务" + Thread.currentThread().getName() + "执行结束, left:" + phaser.getUnarrivedParties());
            });
        }

        System.out.println("主任务完成1============,current time:" + System.currentTimeMillis());
        Thread.sleep(3000);
        phaser.forceTermination();
        System.out.println("主任务完成2============,current time:" + System.currentTimeMillis());
//        phaser.arriveAndAwaitAdvance();


    }
}
