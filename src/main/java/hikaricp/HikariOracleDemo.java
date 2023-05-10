package hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Tyoukai
 * @Date: 2023/4/25 13:57
 */
public class HikariOracleDemo {
    public static void main(String[] args) throws SQLException {
        //实例化类
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        //设置url
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@172.16.125.224:1521:Desendb");
        //数据库帐号
        hikariConfig.setUsername("ekp13");
        //数据库密码
        hikariConfig.setPassword("ekp13");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("select * from EKP13.KM_REVIEW_MAIN WHERE rownum < 10");
            while (rs.next()) {
                System.out.println(rs.getString("FD_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
