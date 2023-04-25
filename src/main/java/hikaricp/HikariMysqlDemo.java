package hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Tyoukai
 * @Date: 2023/4/25 11:13
 */
public class HikariMysqlDemo {

    public static void main(String[] args) throws SQLException {
        //实例化类
        HikariConfig hikariConfig = new HikariConfig();
        //设置url
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/cmdbtest?characterEncoding=UTF-8&useUnicode=true&useSSL=false");
        //数据库帐号
        hikariConfig.setUsername("");
        //数据库密码
        hikariConfig.setPassword("");
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
            rs = statement.executeQuery("select * from om_data_sources");
            while (rs.next()) {
                System.out.print(rs.getString("id") + ",");
                System.out.println(rs.getString("name"));
                System.out.println();
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
