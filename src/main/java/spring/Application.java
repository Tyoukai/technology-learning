package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.extend.Son1;
import spring.extend.Son2;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("E:\\code\\technology-learning\\src\\main\\resources\\application.xml");
        Son1 son1 = (Son1) applicationContext.getBean("son1");
        Son2 son2 = (Son2) applicationContext.getBean("son2");


//        FactoryApplicationAware factoryApplicationAware = (FactoryApplicationAware) applicationContext.getBean("factoryApplicationAware");
//
//        System.out.println(factoryApplicationAware.getItemObtainSupport("jDItemObtainSupport").obtainItem(1));
    }
}
