package cat;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/10 18:53
 */
public class TransactionDemo {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Transaction t = Cat.newTransaction("test", "name");
            Thread.sleep(1000);
            Transaction t1 = Cat.newTransaction("t1", "t1");
            Thread.sleep(1000);
            t.setStatus(Transaction.SUCCESS);
            t1.setStatus(new Exception("t1异常"));
            t1.complete();
            t.complete();
        }
     }
}
