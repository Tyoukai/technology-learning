package influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

/**
 * @Author: Tyoukai
 * @Date: 2024/10/15 9:34
 */
public class InfluxdbConnectDemo {
    public static void main(String[] args) {
        String url = "http://172.16.68.73:10002";
        String username = "puyh";
        String password = "puyunhang1998.";

        InfluxDB influxDB = InfluxDBFactory.connect(url, username, password);
        QueryResult queryResult = influxDB.query(new Query("SELECT * FROM \"cbd_slb_cpu\" ORDER BY \"time\" DESC LIMIT 10", "telegraf"));
        for (QueryResult.Result result : queryResult.getResults()) {
            System.out.println(result.getSeries().get(0).getValues().get(0));
        }

        System.out.println(queryResult);
    }
}
