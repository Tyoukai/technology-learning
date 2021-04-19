package abTest;

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
            System.out.println(aResult);
            System.out.println(bResult);
        }, personNew -> {
            Person person = new Person();
            person.setIdCard(personNew.getIdCard());
            person.setAge(personNew.getAge());
            person.setName(personNew.getName());
            return person;
        });
        String idCard = "123";
        while (true) {
            Person result = helper.doABTest(() -> api.api1(idCard), () -> api.api2(idCard), Long.parseLong(idCard));
            System.out.println(result);
            System.out.println("==========");
            Thread.sleep(1000);
        }

    }
}
