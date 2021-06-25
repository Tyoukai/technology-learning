package cat;

import java.util.Random;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-25
 */
public class CatDemo {
    private static Random random = new Random();
    public static void main(String[] args) {
        while (true) {
            String orderId = random.nextLong() + "";
            Transaction t1 = null;
            try {
                t1 = Cat.newTransaction("order.monitoring", orderId);

                // 扣减库存
                // 扣减优惠券
                // 订单落库
                Thread.sleep(random.nextInt(3000));

                // 下单成功，记录打点
                t1.setStatus(Transaction.SUCCESS);
            } catch (Exception e) {
                t1.setStatus("fail");
                // 上传错误日志
                Cat.logError(e);
            } finally {
                // 上报打点信息
                t1.complete();
            }

            // 记录下单的总次数，及预测趋势
            Cat.logMetricForCount("order.count.record");

        }
    }
}
