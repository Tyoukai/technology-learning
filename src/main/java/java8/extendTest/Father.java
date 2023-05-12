package java8.extendTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/12 13:45
 */
public class Father {

    private static final Map<String, String> fatherMap = new HashMap<>();
    protected String message;
    protected final Map<String, String> map = new HashMap<>();

    public Map<String, String> getFatherMap() {
        return fatherMap;
    }
}
