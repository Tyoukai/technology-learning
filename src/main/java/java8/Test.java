package java8;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-27
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("");

        for (int i = 1003; i <= 1101 ; i++) {
            System.out.println("update hst_data_shard_config_log set config = '{\"startDateStr\":\"2021-01-08\","
                    + "\"step\":\"4\",\"finalDateStr\":\"2020-08-01\"}' where id = " + i + ";");
        }
    }
}
