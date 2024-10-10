package java8.extendTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Tyoukai
 * @Date: 2023/5/12 13:45
 */
public abstract class Father {

    private static final Map<String, String> fatherMap = new HashMap<>();
    protected String message;
    protected final Map<String, String> map = new HashMap<>();
    private String like;

    public Map<String, String> getFatherMap() {
        return fatherMap;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    Father() {
        init();
    }

    public static void init() {
        System.out.println("father init");
    }
}
