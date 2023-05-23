package tDengine;

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

        for (int i = 0; i < 10; i++) {
            String sql = "INSERT INTO operation_test.om_0_test USING operation_test.om_stable_metric TAGS(1, 1, 'name', 'originName') VALUES('2023-05-15 15:42:16', '" + i + "')";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            Thread.sleep(2000);
            System.out.println("1111");
        }

        connection.close();
    }

}
