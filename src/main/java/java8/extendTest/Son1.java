package java8.extendTest;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/12 13:47
 */
public class Son1 extends Father{

    @Override
    public void doWork(Task task) {
        System.out.println("son1 do task:" + task.taskName);
    }
}
