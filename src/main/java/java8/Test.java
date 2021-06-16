package java8;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-27
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("");

        for (int i = 301; i <= 997 ; i = i + 8) {
            System.out.println("update hst_data_shard_config_log set config = '{\"startDateStr\":\"2020-11-23\","
                    + "\"step\":\"3\",\"finalDateStr\":\"2020-08-01\"}' where name = 'MerchantThirdRefundOrderHistorySyncTask' and shard_id = " + i + ";");
        }
    }
}
