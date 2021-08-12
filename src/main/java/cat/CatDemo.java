//package cat;
//
//import java.util.Random;
//
//import com.dianping.cat.Cat;
//import com.dianping.cat.message.Transaction;
//
///**
// * @author zhangkwei <zhangkewei@kuaishou.com>
// * Created on 2021-06-25
// */
//public class CatDemo {
//    private static Random random = new Random();
//    public static void main(String[] args) {
//        while (true) {
//            String orderId = Math.abs(random.nextLong()) + "";
//            Transaction t1 = null;
//            try {
//                t1 = Cat.newTransaction("order.monitoring", orderId);
//
//                if (random.nextInt(10) < 3) {
//                    throw new Exception("order Exception");
//                }
//
//                Transaction t2 = Cat.newTransaction("order.stock", orderId);
//                // 扣减库存
//                Thread.sleep(random.nextInt(20));
//                t2.complete();
//
//                Transaction t3 = Cat.newTransaction("order.coupon", orderId);
//                // 扣减优惠券
//                Thread.sleep(random.nextInt(20));
//                t3.complete();
//
//                Transaction t4 = Cat.newTransaction("order.databse", orderId);
//                // 订单落库
//                Thread.sleep(random.nextInt(20));
//                t4.complete();
//
//
//
//                Thread.sleep(random.nextInt(300));
//
//                // 下单成功，记录打点
//                t1.setStatus(Transaction.SUCCESS);
//            } catch (Exception e) {
//                t1.setStatus("fail order");
//                // 上传错误日志
//                Cat.logError(e);
//            } finally {
//                // 上报打点信息
//                t1.complete();
//            }
//
//            // 记录下单的总次数
//            // MerchantPerfUtils.adMerchantPerf("order.count.record");
//            Cat.logMetricForCount("order.count.record");
//
//        }
//    }
//}
