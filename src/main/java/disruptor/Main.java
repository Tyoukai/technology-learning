package disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-31
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 指定事件工厂
        LogEventFactory factory = new LogEventFactory();

        // 设置ringbuffer的大小
        int bufferSize = 1024;

        // 设置单线程模式
        Disruptor<LogEvent> disruptor = new Disruptor<LogEvent>(factory, bufferSize, executorService,
                ProducerType.SINGLE, new YieldingWaitStrategy());


//        main.testEventHandler();
//        main.testWorkHandler(startTime, executorService, disruptor);
        main.testMixedHandler(startTime, executorService, disruptor);

    }

    /**
     * 测试EventHandler
     *
     * @param startTime
     * @param service
     * @param disruptor
     */
    public void testEventHandler(long startTime, ExecutorService service, Disruptor<LogEvent> disruptor) {

        // 设置消费者
        disruptor.handleEventsWith(new LogEventHandler(1), new LogEventHandler(2));

        // 启动disruptor
        disruptor.start();

        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();

        Producer producer = new Producer(ringBuffer);

        for (int i = 0; i < 2; i++) {
            producer.produceLog(i);
        }

        disruptor.shutdown();
        service.shutdown();

        System.out.println("总共耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 测试WorkHandler
     *
     * @param startTime
     * @param service
     * @param disruptor
     */
    public void testWorkHandler(long startTime, ExecutorService service, Disruptor<LogEvent> disruptor) {
        disruptor.handleEventsWithWorkerPool(new LogWorkHandler(1), new LogWorkHandler(2));

        disruptor.start();

        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();

        Producer producer = new Producer(ringBuffer);

        for (int i = 0; i < 2; i++) {
            producer.produceLog(i);
        }

        disruptor.shutdown();
        service.shutdown();

        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public void testMixedHandler(long startTime, ExecutorService service, Disruptor<LogEvent> disruptor) {
        disruptor.handleEventsWithWorkerPool(new LogWorkHandler(1), new LogWorkHandler(2))
                .then(new LogEventHandler(3), new LogEventHandler(4))
                .thenHandleEventsWithWorkerPool(new LogWorkHandler(5), new LogWorkHandler(6));

        disruptor.start();

        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();

        Producer producer = new Producer(ringBuffer);
        for (int i = 0; i < 3; i++) {
            producer.produceLog(i);
        }

        service.shutdown();
        disruptor.shutdown();

        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }


}
