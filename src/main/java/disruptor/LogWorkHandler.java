package disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-31
 */
public class LogWorkHandler implements WorkHandler<LogEvent> {

    private int id;

    LogWorkHandler(int id) {
        this.id = id;
    }

    @Override
    public void onEvent(LogEvent event) throws Exception {
        System.out.println("LogWorkHandler " + id + ":" + event);
    }
}
