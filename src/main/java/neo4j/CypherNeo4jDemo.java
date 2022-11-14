package neo4j;

import org.neo4j.cypher.internal.ExecutionEngine;
import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * @author Echo
 * @Date 2022/11/12 14:44
 */
public class CypherNeo4jDemo {

    public static void main(String[] args) {
        // 1. 获取graphDB
        GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();
//        GraphDatabaseService graphDb = graphDbFactory.newEmbeddedDatabase("C:/TPNeo4jDB");
//        // 2. 获取Cypher执行引擎
//        ExecutionEngine execEngine = new ExecutionEngine(graphDb);
//        ExecutionResult execResult = execEngine.execute("MATCH (java:JAVA) RETURN java");
//        // 3. 获取执行结果
//        String results = execResult.dumpToString();
//        System.out.println(results);
    }
}
