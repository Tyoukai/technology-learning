package abTest;

import java.util.Map;

/**
 * 总的模拟入口
 *
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-16
 */
public class MainTest {
    public static void main(String[] args) {
        OuterApi api = new OuterApi();

        while (true) {
            Map<String, String> result = AbTestUtils.doABTest(api::api1, api::api2);
        }

    }
}
