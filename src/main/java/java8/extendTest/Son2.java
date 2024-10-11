package java8.extendTest;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/12 13:47
 */
public class Son2 extends Father {
    @Override
    public void doWork(Task task) {
        System.out.println("son2 do task:" + task.taskName);
    }
}
