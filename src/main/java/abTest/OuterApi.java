package abTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 模拟外部api
 *
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-16
 */
public class OuterApi {
    private Random random = new Random();

    public Person api1(String idCard) {
        Person person = new Person();
        person.setName("小张");
        if (random.nextDouble() < 0.5) {
            person.setAge("13");
        } else {
            person.setAge("15");
        }
        person.setIdCard(idCard);
        return person;
    }

    public PersonNew api2(String idCard) {
        PersonNew personNew = new PersonNew();
        personNew.setName("小张");
        if (random.nextDouble() < 0.5) {
            personNew.setAge("13");
        } else {
            personNew.setAge("15");
        }
        personNew.setSex("1");
        personNew.setIdCard(idCard);
        return personNew;
    }
}
