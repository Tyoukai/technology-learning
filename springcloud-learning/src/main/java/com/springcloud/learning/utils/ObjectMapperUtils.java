package com.springcloud.learning.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import static com.fasterxml.jackson.databind.type.TypeFactory.defaultInstance;


public class ObjectMapperUtils {
    public static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

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
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param jsonStr
     * @param valueType
     * @param collectionType
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
            e.printStackTrace();
            return null;
        }
    }
}
