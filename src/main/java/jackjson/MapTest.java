package jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/15 15:27
 */
public class MapTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        Map<String, String> map1 = new HashMap<>();
        map1.put("map1", "map1");
        map1.put("name", "zhangsan");

        map.put("string", "string");
        map.put("mapString", "mapString");
//        map.put("map1", map1);

        System.out.println(mapper.writeValueAsString(map));

    }
}
