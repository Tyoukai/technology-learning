package java8.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: Tyoukai
 * @Date: 2023/6/28 10:27
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            return 1;
        });

        new Thread(futureTask).start();

        futureTask.get();
    }
}
