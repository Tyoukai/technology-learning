package neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * @author Echo
 * @Date 2022/11/14 15:33
 */
public class VideoDemo {
    public static void main(String[] args) {
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        File file = new File("D:/panguNeo4jTest");
        GraphDatabaseService db= dbFactory.newEmbeddedDatabase(file);

        try(Transaction tx = db.beginTx()) {
            Node system = db.createNode(CiType.应用系统);
            system.setProperty("name", "测试应用系统");
            system.setProperty("id", 1);

            Node module1 = db.createNode(CiType.应用模块);
            module1.setProperty("name", "ens_client");
            module1.setProperty("id", 2);

            Node module2 = db.createNode(CiType.应用模块);
            module2.setProperty("name", "easy_command");
            module2.setProperty("id", 3);

            Node module3 = db.createNode(CiType.应用模块);
            module3.setProperty("name", "gateway");
            module3.setProperty("id", 4);

            Node module4 = db.createNode(CiType.应用模块);
            module4.setProperty("name", "易淘云行情监控");
            module4.setProperty("id", 5);

            Node module5 = db.createNode(CiType.应用模块);
            module5.setProperty("name", "新一代集中交易模块");
            module5.setProperty("id", 6);

            Node module6 = db.createNode(CiType.应用模块);
            module6.setProperty("name", "pipeline");
            module6.setProperty("id", 7);

            Node module7 = db.createNode(CiType.应用模块);
            module7.setProperty("name", "ens_server");
            module7.setProperty("id",8);

            module1.createRelationshipTo(system, CiRelationType.组成);
            module2.createRelationshipTo(system, CiRelationType.组成);
            module3.createRelationshipTo(system, CiRelationType.组成);
            module4.createRelationshipTo(system, CiRelationType.组成);
            module5.createRelationshipTo(system, CiRelationType.组成);
            module6.createRelationshipTo(system, CiRelationType.组成);
            module7.createRelationshipTo(system, CiRelationType.组成);

            module1.createRelationshipTo(module5, CiRelationType.使用);
            module1.createRelationshipTo(module2, CiRelationType.使用);
            module2.createRelationshipTo(module6, CiRelationType.使用);
            module3.createRelationshipTo(module6, CiRelationType.使用);
            module6.createRelationshipTo(module3, CiRelationType.使用);
            module3.createRelationshipTo(module7, CiRelationType.使用);
            module7.createRelationshipTo(module3, CiRelationType.使用);
            module4.createRelationshipTo(module7, CiRelationType.使用);
            module7.createRelationshipTo(module4, CiRelationType.使用);

            tx.success();
        } catch (Exception e) {
            e.printStackTrace();
        }




        try(Transaction tx = db.beginTx()) {
            Node system = db.createNode(CiType.应用系统);
            system.setProperty("name", "app系统");
            system.setProperty("id", -1);

            Node module0 = db.createNode(CiType.应用模块);
            module0.setProperty("name", "nginx");
            module0.setProperty("id", 0);

            Node module1 = db.createNode(CiType.应用模块);
            module1.setProperty("name", "app1");
            module1.setProperty("id", 1);

            Node module2 = db.createNode(CiType.应用模块);
            module2.setProperty("name", "app2");
            module2.setProperty("id", 2);

            Node module3 = db.createNode(CiType.应用模块);
            module3.setProperty("name", "app3");
            module3.setProperty("id", 3);

            Node module4 = db.createNode(CiType.应用模块);
            module4.setProperty("name", "db1");
            module4.setProperty("id", 4);

            Node module5 = db.createNode(CiType.应用模块);
            module5.setProperty("name", "db2");
            module5.setProperty("id", 5);


            module0.createRelationshipTo(system, CiRelationType.组成);
            module1.createRelationshipTo(system, CiRelationType.组成);
            module2.createRelationshipTo(system, CiRelationType.组成);
            module3.createRelationshipTo(system, CiRelationType.组成);
            module4.createRelationshipTo(system, CiRelationType.组成);
            module5.createRelationshipTo(system, CiRelationType.组成);

            module0.createRelationshipTo(module1, CiRelationType.使用);
            module0.createRelationshipTo(module2, CiRelationType.使用);
            module0.createRelationshipTo(module3, CiRelationType.使用);

            module1.createRelationshipTo(module4, CiRelationType.使用);
            module1.createRelationshipTo(module5, CiRelationType.使用);

            module2.createRelationshipTo(module4, CiRelationType.使用);
            module2.createRelationshipTo(module5, CiRelationType.使用);

            module3.createRelationshipTo(module4, CiRelationType.使用);
            module3.createRelationshipTo(module5, CiRelationType.使用);

            tx.success();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
