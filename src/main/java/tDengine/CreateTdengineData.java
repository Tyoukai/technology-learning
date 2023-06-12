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


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long timestamp = 1685858446000L;
        long current = System.currentTimeMillis();
        for (; timestamp < current; ) {
            String timeStr = format.format(timestamp);
            int rowCount = stmt.executeUpdate(createSql(timeStr, "cpu_usage1", "机器1CPU使用率", "10981", "1"));
            System.out.println(rowCount);
            timestamp += 60023;
        }

        stmt.close();
    }

    public static String createSql(String time, String name, String nameShow, String nameOrigin, String metricId) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("nameShow", nameShow);
        map.put("nameOrigin", nameOrigin);
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("zabbixMysql", random.nextFloat() * 1000 + "");
        map.put("value", valueMap);


        // "INSERT INTO om_metrics.${tableName} USING pangu_om.om_metrics TAGS(${dataSourceId}, ${metricId}, ${name}, ${nameOrigin}) VALUES(${timestamp}, ${metricStr})";
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO operation_test.om_0_");
        sb.append(metricId);
        sb.append(" USING operation_test.om_metrics TAGS('").append("0',").append("'").append(metricId).append("'").append(",'").append(name).append("','").append(nameOrigin).append("'")
                .append(") VALUES ('").append(time).append("','").append(objectMapper.writeValueAsString(map)).append("')");


        return sb.toString();
    }





}
