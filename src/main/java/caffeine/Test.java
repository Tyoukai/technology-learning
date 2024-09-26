package caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * @Author: Tyoukai
 * @Date: 2024/9/18 11:20
 */
public class Test {
    public static void main(String[] args) {
        Cache<String, Integer> cache = Caffeine.newBuilder().build();
        System.out.println(cache.get("122", key -> null));
        System.out.println(cache.asMap().size());
        cache.put("122", 1);
    }
}
