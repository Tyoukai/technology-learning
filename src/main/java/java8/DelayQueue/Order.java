package java8.DelayQueue;

import org.apache.kafka.common.protocol.types.Field;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Echo
 * @Date 2022/9/27 10:16
 */
public class Order implements Delayed {
    private long executeTime;

    private String name;

    public Order(String name, long executeTime) {
        this.executeTime = executeTime + System.currentTimeMillis();
        this.name = name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return executeTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Order order = (Order) o;
        long diff = this.executeTime - order.executeTime;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public void addExecuteTime(long time) {
        this.executeTime += time;
    }


}
