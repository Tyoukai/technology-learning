package caffeine;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @Author: Tyoukai
 * @Date: 2023/8/18 15:22
 */
public class LoadingCacheDemo {
    public static void main(String[] args) {
        LoadingCache<String, String> cache = Caffeine.newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Nullable
                    @Override
                    public String load(@Nonnull String s) throws Exception {
                        return null;
                    }
                });
    }
}
