package abTest;

import java.util.Collections;
import java.util.Map;

/**
 * 模拟外部api
 *
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-16
 */
public class OuterApi {
    public Map<String, String> api1() {
        Map<String, String> map = Collections.emptyMap();
        map.put("name", "abtest");
        map.put("age", "13");
        return map;
    }

    public Map<String, String> api2() {
        Map<String, String> map = Collections.emptyMap();
        map.put("name", "abtest");
        map.put("age", "13");
        map.put("sex", "1");
        return map;
    }
}
