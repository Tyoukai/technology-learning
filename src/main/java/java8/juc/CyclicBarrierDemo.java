package java8.juc;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * @Author: Tyoukai
 * @Date: 2023/6/12 10:34
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        CyclicBarrier barrier = new CyclicBarrier(n,
                () -> System.out.println("All threads have reached the barrier"));

        Thread t1 = new Thread(new MyRunnable(barrier), "Thread 1");
        Thread t2 = new Thread(new MyRunnable(barrier), "Thread 2");
        Thread t3 = new Thread(new MyRunnable(barrier), "Thread 3");

        t1.start();
        t2.start();
        t3.start();


        Thread.sleep(10000L);
        System.out.println("======================================");
        t1 = new Thread(new MyRunnable(barrier), "Thread 4");
        t2 = new Thread(new MyRunnable(barrier), "Thread 5");
        t3 = new Thread(new MyRunnable(barrier), "Thread 6");

        t1.start();
        t2.start();
        t3.start();

    }

    static class MyRunnable implements Runnable {
        private final CyclicBarrier barrier;

        public MyRunnable(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        public void run() {
            try {
                Thread.sleep((long) (Math.random() * 5000));
                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier...");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

