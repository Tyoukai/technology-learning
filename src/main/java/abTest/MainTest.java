package abTest;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * 总的模拟入口
 *
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-16
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        OuterApi api = new OuterApi();

        AbTestHelper<Person, PersonNew> helper = new AbTestHelper<>((person, person1) -> {
            if (person == null || person1 == null) {
                return -1;
            }
            if (StringUtils.equals(person.getAge(), person1.getAge()) && StringUtils.equals(person.getIdCard(), person1.getIdCard()) &&
            StringUtils.equals(person.getName(), person1.getName())) {
                return 0;
            }
            return -1;
        }, (aResult, bResult) -> {
            // 当发现两者结果不相同时，一般是通过埋点的方式上报。这里简单的输出一下各自接口的值
            System.out.println("新旧接口返回值不相同，原始接口获取的年龄：" + aResult.getAge() + "，新接口获取的年龄：" + bResult.getAge());
        }, personNew -> {
            Person person = new Person();
            person.setIdCard(personNew.getIdCard());
            person.setAge(personNew.getAge());
            person.setName(personNew.getName());
            return person;
        });
        Random random = new Random();

        while (true) {
            String idCard = random.nextInt(100) + "";
            Person result = helper.doABTest(() -> api.api1(idCard), () -> api.api2(idCard), Integer.parseInt(idCard));
            System.out.println(result.toString());
            System.out.println("==========");
            Thread.sleep(1000);
        }

    }
}
