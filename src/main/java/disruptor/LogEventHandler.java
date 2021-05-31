package disruptor;

import com.lmax.disruptor.EventHandler;
/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-31
 */
public class LogEventHandler implements EventHandler<LogEvent> {

    private int id;

    LogEventHandler(int id) {
        this.id = id;
    }

    @Override
    public void onEvent(LogEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("LogEventHandler " + id + ":" + event);
    }
}
