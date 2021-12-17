package guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-23
 */
public class RateLimiterTest {
    public static void main(String[] args) {
        singleLimiter();
    }

    private static void singleLimiter() {
        RateLimiter limiter = RateLimiter.create(1);
        for (int i = 1; i < 10; i = i + 2) {
            double waitTime = limiter.acquire(i);
            System.out.println("i:" + i + ", 等待的时间:" + waitTime);
        }
    }
}
