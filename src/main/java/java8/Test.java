package java8;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-27
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("");

        for (int i = 308; i <= 996 ; i = i + 8) {
            System.out.println("update hst_data_shard_config_log set config = '{\"startDateStr\":\"2021-04-04\","
                    + "\"step\":\"3\",\"finalDateStr\":\"2020-08-01\"}' where id = " + i + ";");
        }
    }
}
