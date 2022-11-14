package neo4j;


import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Echo
 * @Date 2022/11/12 12:13
 */
public class NativeNeo4jDemo {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.16.123.188:3306/cmdbtest";  // 172.16.123.188  生产：jdbc:mysql://172.16.64.9:3306/cmdb

    static final String USER = "cmdbtest";  // 生产：cmdb
    static final String PASS = "cmdbtest"; // 生产：cmdb

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {

            GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
            File file = new File("D:/panguNeo4j");
            GraphDatabaseService db= dbFactory.newEmbeddedDatabase(file);

            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");

            // 1、创建单节点实例
            Map<String, Node> nodeMap = createSingleNode(conn, db);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM ci_relation_ins";
            ResultSet rs = stmt.executeQuery(sql);

            // 2、设置节点间的关系
            while (rs.next()) {
                    try (Transaction tx = db.beginTx()) {
                        String typeIdFrom = rs.getString("type_id_from");
                        String relationId = rs.getString("relation_id");
                        String typeIdTo = rs.getString("type_id_to");
                        String ciIdFrom = rs.getString("ci_id_from");
                        String ciIdTo = rs.getString("ci_id_to");

                        Node fromNode = nodeMap.get(ciIdFrom);
                        Node toNode = nodeMap.get(ciIdTo);
                        if (fromNode == null || toNode == null) {
                            tx.success();
                            continue;
                        }
                        createRelation(fromNode, toNode, relationId);
                        System.out.println("节点关系被创建：" + ciIdFrom);
                        tx.success();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done successfully");
    }

    public static Node createNode(String nodeId, String typeId,  Connection conn, GraphDatabaseService db) throws SQLException {
        Node node = db.createNode(CiType.getType(typeId));
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ci WHERE ci_id = ").append("'").append(nodeId).append("'");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sb.toString());
        if (rs.next()) {
            String attrCiName = rs.getString("attrCiName");
            if (attrCiName != null) {
                node.setProperty("name", rs.getString("attrCiName"));
                node.setProperty("id", nodeId);
            }
        }

        stmt.close();
        return node;
    }

    public static void createRelation(Node fromNode, Node toNode, String relationId) {
        Relationship relationship = fromNode.createRelationshipTo(toNode, CiRelationType.getType(relationId));
    }

    public static Map<String, Node> createSingleNode(Connection conn, GraphDatabaseService db) throws SQLException {
        String sql = "SELECT * from ci";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Map<String, Node> map = new HashMap<>();
        while (rs.next()) {
            try (Transaction tx = db.beginTx()) {
                String ciId = rs.getString("ci_id");
                String typeId = rs.getString("type_id");
                String attrCiName = rs.getString("attrCiName");

                if(attrCiName == null || ciId == null) {
                    tx.success();
                    continue;
                }

                Node node = db.createNode(CiType.getType(typeId));
                node.setProperty("name", attrCiName);
                node.setProperty("id", ciId);

                map.put(ciId, node);
                System.out.println("单节点被创建：" + ciId);
                tx.success();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stmt.close();
        return map;
    }

}
