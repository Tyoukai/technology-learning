package abTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 总的模拟入口
 *
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-16
 */
public class MainTest {
    public static void main(String[] args) {
        OuterApi api = new OuterApi();
        List<String> list = new ArrayList<>();

        AbTestHelper<Person, PersonNew> helper = new AbTestHelper<>((person, person1) -> {
            if (person == null || person1 == null) {
                return -1;
            }
            if (StringUtils.equals(person.getAge(), person1.getAge()) && StringUtils.equals(person.getIdCard(), person1.getIdCard()) &&
            StringUtils.equals(person.getName(), person1.getName())) {
                return 0;
            }
            return -1;
        }, null, null);
        String idCard = "123";
        while (true) {
            Person result = helper.doABTest(() -> api.api1(idCard), () -> api.api2(idCard), Long.parseLong(idCard));
        }

    }
}
