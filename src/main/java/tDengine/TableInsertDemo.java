package tDengine;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/22 16:49
 */
public class TableInsertDemo {
    public static void main(String[] args) throws SQLException, InterruptedException {
        String jdbcUrl = "jdbc:TAOS-RS://172.16.66.18:6041?user=root&password=taosdata";
        Connection connection = DriverManager.getConnection(jdbcUrl);

        int count = 1;
        while (true) {
            String date = DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS");
            String sql = "INSERT INTO operation_test.om_0_test USING operation_test.om_stable_metric TAGS(1, 1, 'name', 'originName') VALUES('" + date + "', '" + count + "')";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            count++;
            if (count > 10000) {
                break;
            }
            Thread.sleep(1);
        }

        connection.close();
    }

}
