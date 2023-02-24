package tDengine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Echo
 * @Date 2023/2/22 14:29
 */
public class CreateTdengineData {
    private static Random random = new Random();
    private static ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) throws SQLException, JsonProcessingException {
        Connection conn = TDengineDemo.getConnection();
        Statement stmt = conn.createStatement();


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timestamp = 1677186000000L;
        long current = System.currentTimeMillis();
        for (; timestamp < current; ) {
            String timeStr = format.format(timestamp);
            int rowCount = stmt.executeUpdate(createSql(timeStr, "cpu_usage3", "机器3CPU使用率", "10982", "3"));
            System.out.println(rowCount);
            timestamp += 60000;
        }

        stmt.close();
    }

    public static String createSql(String time, String name, String nameShow, String nameOrigin, String metricId) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("nameShow", nameShow);
        map.put("nameOrigin", nameOrigin);
        map.put("value", random.nextFloat() * 1000 + "");


        // "INSERT INTO om_metrics.${tableName} USING pangu_om.om_metrics TAGS(${dataSourceId}, ${metricId}, ${name}, ${nameOrigin}) VALUES(${timestamp}, ${metricStr})";
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO operation_test.om_0_");
        sb.append(metricId);
        sb.append(" USING operation_test.om_metrics TAGS('").append("0',").append("'").append(metricId).append("'").append(",'").append(name).append("','").append(nameOrigin).append("'")
                .append(") VALUES ('").append(time).append("','").append(objectMapper.writeValueAsString(map)).append("')");


        return sb.toString();
    }





}
