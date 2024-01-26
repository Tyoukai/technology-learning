package hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Tyoukai
 * @Date: 2023/4/25 11:13
 */
public class HikariMysqlDemo {

    public static void main(String[] args) throws SQLException {
        //实例化类
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //设置url
        hikariConfig.setJdbcUrl("jdbc:mysql://172.16.123.188:3306/cmdbtest?characterEncoding=UTF-8&useUnicode=true&useSSL=false");
        //数据库帐号
        hikariConfig.setUsername("cmdbtest");
        //数据库密码
        hikariConfig.setPassword("cmdbtest");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(hikariConfig);
//        Connection conn = null;
//        Statement statement = null;
//        ResultSet rs = null;
        try {
//            while (true) {
//                Connection conn = ds.getConnection();
//                Statement statement = conn.createStatement();
//                ResultSet rs = statement.executeQuery("select count(*) from om_data_sources ds");
//                while (rs.next()) {
//                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//                        System.out.print(rs.getString(rs.getMetaData().getColumnLabel(i)) + ",");
//                    }
//                    System.out.println();
//                }
//                statement.close();
//                conn.close();
//                Thread.sleep(1000L);
//            }
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from om_metrics where data_source_id = -1");
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(rs.getMetaData().getColumnLabel(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
