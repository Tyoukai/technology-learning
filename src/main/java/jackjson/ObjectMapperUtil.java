package jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Collection;

import static com.fasterxml.jackson.databind.type.TypeFactory.defaultInstance;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/22 9:29
 */
public class ObjectMapperUtil {
    public static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 转换数据类型为集合类型，集合内部类型为java基础类型
     *
     * @param jsonStr
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T fromJson(Object jsonStr, Class<T> valueType) {
        if (jsonStr == null) {
            return null;
        }
        try {
            if (jsonStr instanceof  String) {
                return mapper.readValue((String) jsonStr, valueType);
            } else if (jsonStr instanceof byte[]) {
                return mapper.readValue((byte[]) jsonStr, valueType);
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    /**
     *转换数据为集合类型，集合类型内部为自定义数据对象
     *
     * @param jsonStr
     * @param valueType 集合中自定义数据类型，例如List<Person> 填写Person.class
     * @param collectionType 集合类型，如：Map.class, List.class
     * @param <E>
     * @param <T>
     * @return
     *
     * ObjectMapperUtils.mapper.readValue(allRoute, new TypeReference<List<RouteDefinition>>(){});
     */
    public static <E, T extends Collection<E>> T fromJson(String jsonStr, Class<E> valueType,
                                                          Class<? extends Collection> collectionType) {
        try {
            return mapper.readValue(jsonStr, defaultInstance().constructCollectionType(collectionType, valueType));
        } catch (IOException e) {
            return null;
        }
    }
}