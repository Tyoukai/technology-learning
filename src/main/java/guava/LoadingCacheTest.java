package guava;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java8.Person;

/**
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-04-27
 */
public class LoadingCacheTest {
    public static void main(String[] args) throws InterruptedException {
        LoadingCache<Integer, Person> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .removalListener(
                        new RemovalListener<Integer, Person>() {
                            @Override
                            public void onRemoval(RemovalNotification<Integer, Person> notification) {
                                System.out.println(notification.getKey() + "," + notification.getValue());
                            }
                        }
                )
                .build(
                        new CacheLoader<Integer, Person>() {
                            @Override
                            public Person load(Integer key) throws Exception {
                                Person person = new Person(4, "ss");
                                return  person;
                            }
                        }
                );

        Person person = new Person(1, "1");
        cache.put(1, person);
        Thread.sleep(10 * 1000);

        System.out.println(cache.size());
    }
}
