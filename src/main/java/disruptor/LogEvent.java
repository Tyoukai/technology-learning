package disruptor;

import java.io.Serializable;


/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-05-31
 */
public class LogEvent implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "id=" + id +
                '}';
    }
}
