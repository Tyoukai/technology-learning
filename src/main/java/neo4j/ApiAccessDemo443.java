//package neo4j;
//
//import org.neo4j.driver.Driver;
//import org.neo4j.driver.GraphDatabase;
//import org.neo4j.driver.Session;
//
//import static org.neo4j.driver.Values.parameters;
//
///**
// * @Author: Tyoukai
// * @Date: 2024/1/8 10:44
// */
//public class ApiAccessDemo443 {
//
//    public static void main(String[] args) {
//        Driver driver = GraphDatabase.driver("bolt://172.19.185.27:7687");
//        Session session = driver.session();
//
//        // 统计节点个数
////        String query = "match (n) return count(n)";
////        int count = session.readTransaction(transaction -> transaction.run(query, parameters()).single().get(0).asInt());
////        System.out.println(count);
//        session.run("match (n) return count(n)");
//    }
//}
