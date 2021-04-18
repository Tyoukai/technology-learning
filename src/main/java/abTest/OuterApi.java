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
    public Map<String, String> api1() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "abtest");
        map.put("age", "13");
        map.put("idCard", String.valueOf(random.nextInt(1000)));
        return map;
    }

    public Map<String, String> api2() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "abtest");
        map.put("age", "13");
        map.put("sex", "1");
        return map;
    }
}
