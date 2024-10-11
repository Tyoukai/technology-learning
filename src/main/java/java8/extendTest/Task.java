package java8.extendTest;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Tyoukai
 * @Date: 2024/10/10 13:48
 */
public class Task implements Delayed {
    public String taskName;

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
