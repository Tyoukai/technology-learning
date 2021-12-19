package guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-23
 */
public class RateLimiterTest {
    public static void main(String[] args) {
//        singleLimiter();
//        testSmoothBursty2();
//        testSmoothBursty3();
        setRate();
    }

    private static void singleLimiter() {
        RateLimiter limiter = RateLimiter.create(1);
        for (int i = 1; i < 10; i = i + 2) {
            double waitTime = limiter.acquire(i);
            System.out.println("i:" + i + ", 等待的时间:" + waitTime);
        }
    }

    public static void testSmoothBursty2() {
        RateLimiter r = RateLimiter.create(2);
        while (true)
        {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
        }
    }

    public static void testSmoothBursty3() {
        RateLimiter r = RateLimiter.create(10);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }

        while (true) {
            System.out.println("get 1 tokens: " + r.acquire() + "s");
        }
    }

    public static void setRate() {
        RateLimiter rateLimiter = RateLimiter.create(2);
        long now = System.currentTimeMillis();
        while (true) {
            if ((System.currentTimeMillis() - now) > 5000) {
                rateLimiter.setRate(10);
                System.out.println("----------rate change-----------");
            }
            System.out.println("get 1 tokens: " + rateLimiter.acquire() + "s" + "current rate: " + rateLimiter.getRate());
        }
    }





}
