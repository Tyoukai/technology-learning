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
    static LoadingCache<Integer, Person> cache = CacheBuilder.newBuilder()
            .maximumSize(3)
            .expireAfterAccess(3, TimeUnit.SECONDS)
//            .expireAfterWrite(2, TimeUnit.SECONDS)
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
                            Person person = new Person(key, "ss");
                            return  person;
                        }
                    }
            );



    public static void main(String[] args) throws InterruptedException {
//        maxSizeTest();
//        timeOutTest();
        loadTest();
    }

    /**
     * 最大容量测试
     */
    private static void maxSizeTest() {
        Person person = new Person(1, "1");
        Person person1 = new Person(2, "2");
        Person person2 = new Person(3, "3");
        Person person3 = new Person(4, "4");
        cache.put(1, person);
        cache.put(2, person1);
        cache.put(3, person2);
        System.out.println(cache.asMap());
        cache.put(4, person3);
        System.out.println(cache.asMap());
    }

    /**
     * 过期删除方法测试
     *
     * @throws InterruptedException
     */
    private static void timeOutTest() throws InterruptedException {
        Person person = new Person(1, "1");
        cache.put(1, person);
        Thread.sleep(2000);
        System.out.println(cache.getUnchecked(1));
        System.out.println(cache.asMap());
    }

    /**
     * load方法测试
     */
    private static void loadTest() {
        System.out.println(cache.getUnchecked(1));

        System.out.println(cache.asMap());
    }
}
