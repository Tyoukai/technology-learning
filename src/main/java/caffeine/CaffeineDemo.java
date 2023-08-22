package caffeine;

import com.github.benmanes.caffeine.cache.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Tyoukai
 * @Date: 2023/8/18 14:55
 */
public class CaffeineDemo {
    public static void main(String[] args) {
        Cache<String, String> caffeine = Caffeine.newBuilder()
                .expireAfterAccess(10000, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Nullable
                    @Override
                    public String load(@Nonnull String s) throws Exception {
                        return "value2";
                    }
                });

        caffeine.put("key1", "value1");

        System.out.println(caffeine.get("key2", k -> {
            System.out.println(k);
            return "value2";
        }));

        System.out.println(caffeine.getIfPresent("key2"));

    }

}
