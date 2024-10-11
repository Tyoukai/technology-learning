package java8.extendTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/12 13:45
 */
public abstract class Father {

    private static final Map<String, String> fatherMap = new HashMap<>();

    protected static final ExecutorService WORKER = new ThreadPoolExecutor(1, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    protected static final DelayQueue<Task> TASK_QUEUE = new DelayQueue<>();

    protected String message;
    protected final Map<String, String> map = new HashMap<>();
    private String like;

    public Map<String, String> getFatherMap() {
        return fatherMap;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    private static volatile boolean isRunning = false;

    Father() {
        if (!isRunning) {
            synchronized (Father.class) {
                if (!isRunning) {
                    isRunning = true;
                    WORKER.submit(() -> {
                        while (true) {
                            Son1Task son1Task = new Son1Task("son1Task");
                            Son2Task son2Task = new Son2Task("son2Task");

                            WORKER.submit(() -> doWork(son1Task));
                            WORKER.submit(() -> doWork(son2Task));

                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {

                            }
                        }
                    });
                }
            }
        }
        init();
    }

    public void init() {
        System.out.println("father init");
    }

    public abstract void doWork(Task task);
}
