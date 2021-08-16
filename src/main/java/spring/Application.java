package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        FactoryApplicationAware factoryApplicationAware = (FactoryApplicationAware) applicationContext.getBean("factoryApplicationAware");

        System.out.println(factoryApplicationAware.getItemObtainSupport("jDItemObtainSupport").obtainItem(1));
    }
}
