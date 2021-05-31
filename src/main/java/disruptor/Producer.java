package disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-31
 */
public class Producer {
    private RingBuffer<LogEvent> ringBuffer;

    Producer(RingBuffer<LogEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void produceLog(int id) {
        long sequence = ringBuffer.next();
        try {
            LogEvent logEvent = ringBuffer.get(sequence);
            logEvent.setId(id);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
