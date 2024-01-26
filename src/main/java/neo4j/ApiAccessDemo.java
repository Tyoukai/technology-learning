package neo4j;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * @Author: Tyoukai
 * @Date: 2024/1/3 10:07
 */
public class ApiAccessDemo {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://172.19.185.27:7687");
        Session session = driver.session();

        // 统计节点个数
//        String query = "match (n) return count(n)";
//        int count = session.readTransaction(transaction -> transaction.run(query, parameters()).single().get(0).asInt());
//        System.out.println(count);

        // 创建节点
//        session.writeTransaction(transaction -> {
//            transaction.run("CREATE (a:Person {name: $name, age:$age})", parameters("age", "12","name", "zkw1"));
//            return null;
//        });

        session.writeTransaction(transaction -> {
            transaction.run("match (a:Person{name:$name}), (b:Person{name:'zkw1'}) merge (a) -[:#relation] -> (b)", parameters("name", "zkw", "relation", "relation"));
            return null;
        });

        // 获取节点
//        StatementResult result = session.run("match (a:Person{name: $name}) return a", parameters("name", "zkw1"));
//        while (result.hasNext()) {
//            Record record = result.next();
//            System.out.println(record.get(0).get("name").asString());
//            System.out.println(record.get(0).get("age").asString());
//        }
        // MATCH (n:Person{name:'Steve'}) -[:BORN_IN] -> (b:Location{city:'Lynn'}) return n, b
        // MATCH (a:Person {name: $name}) RETURN a

//        String name = session.readTransaction(transaction -> {
//            StatementResult result = transaction.run("match (n:Person{name:'zkw'}) -[r] - (b) return n,r,b");
////            System.out.println(result.next().get(0).get("name").asString());
//            Record record = result.next();
//            return record.get(0).get("name").asString();
//        });
//        System.out.println(name);


        // 更新节点
        // 删除节点 MATCH (a:Location {city:'Portland'}) DELETE a
        // 删除属性 MATCH (a:Person {name:'Mike'}) SET a.test='test'
        //         MATCH (a:Person {name:'Mike'}) DELETE a
        // 删除有关系的节点 MATCH (a:Person {name:'Todd'})-[rel]-(b:Person) DELETE a,b,rel
//        session.writeTransaction(transaction -> {
//            transaction.run("MATCH (n:Person{name: $name}) SET n.age=$age", parameters("name", "zkw", "age", "12"));
//            return null;
//        });
//        session.writeTransaction(transaction -> {
//            transaction.run(" MATCH (a:Person {name:'zkw'}) DELETE a");
//            return null;
//        });


        session.close();
        driver.close();
    }
}
