package java8.DelayQueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;

/**
 * @author Echo
 * @Date 2022/9/27 10:21
 */
public class DelayQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        Order order1 = new Order("Order1", 5000);
        Order order2 = new Order("Order2", 10000);
        Order order3 = new Order("Order3", 15000);
        DelayQueue<Order> delayQueue = new DelayQueue<>();
        delayQueue.put(order1);
        delayQueue.put(order2);
        delayQueue.put(order3);

        long currentTime = System.currentTimeMillis();
        System.out.println("订单延迟队列开始时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        order1.addExecuteTime(1000);
        while (delayQueue.size() != 0) {
            /**
             * 取队列头部元素是否过期
             */
            Order order = delayQueue.poll();
            if (order != null) {
                System.out.format("订单:{%s}, 延迟执行的时间:{%s}\n", order.getName(), System.currentTimeMillis() - currentTime);
            }
            Thread.sleep(1000);
        }
    }
}

