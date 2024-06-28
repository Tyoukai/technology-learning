package redis;

import com.google.common.collect.Lists;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RedissonDemo {
    public static void main(String[] args) {
        Config config = new Config();

//        config.useMasterSlaveServers()
//                .setMasterAddress("redis://172.19.185.25:6379")
//                .setPassword("admin123")
//                .addSlaveAddress("redis://172.19.185.26:6379", "redis://172.19.185.27:6379");
//        RedissonClient client = Redisson.create(config);

        config.useMasterSlaveServers()
                .setMasterAddress("redis://172.19.65.23:6379")
                .setPassword("admin123")
                .addSlaveAddress("redis://172.19.65.24:6379", "redis://172.19.65.25:6379");
        RedissonClient client = Redisson.create(config);

//        string(client);
//        hash((client));
//        hashHincrBy(client);
//        zSet(client);

//        client.getKeys().delete("hashTest");
        del(client);

        client.shutdown();



    }

    public static void string(RedissonClient client) {
        RBucket<String> bucket = client.getBucket("test", new StringCodec("utf-8"));
        bucket.set("value");

        String valueInRedis = bucket.get();
        System.out.println(valueInRedis);
    }

    public static void hash(RedissonClient client) {
        RMap<Object, Object> hash = client.getMap("hashTest", new StringCodec("utf-8"));
        Map<String, String> map = new HashMap<>();
        map.put("expireTime", "11111222");
//        map.put("count", "1002221");
        map.put("newKey1", "newValue222");
        hash.putAll(map);

//        int count = Integer.parseInt(hash.addAndGet("count", 100).toString());
//        System.out.println(count);
//        System.out.println("未设置过期时间:" + hash.remainTimeToLive());
//
//        RMap<Object, Object> remainTimeToLive = client.getMap("remainTimeToLive", new StringCodec("utf-8"));
//        remainTimeToLive.put("1", "1");
//        remainTimeToLive.expireAt(System.currentTimeMillis() + 100000);
//        System.out.println("设置了过期时间：" + remainTimeToLive.remainTimeToLive());
//        System.out.println("key不存在过期时间：" + client.getMap("12233").remainTimeToLive());
//
//        // 查看key是否存在
//        System.out.println(client.getMap("isExists", new StringCodec("utf-8")).isExists());
    }

    public static void zSet(RedissonClient client) {
        RScoredSortedSet<String> rScoredSortedSet = client.getScoredSortedSet("zsetTest");
        rScoredSortedSet.addScore("element1", 10);
        rScoredSortedSet.addScore("element2", 20);

    }

    public static void del(RedissonClient client) {
//        List<String> delKeys = new ArrayList<>();
//        client.getKeys().getKeys().forEach(key -> {
//            if (key.startsWith("minute_flow_segment")) {
//                delKeys.add(key);
//            }
//        });
//
//        for (String key : delKeys) {
//            client.getKeys();
//        }
        client.getKeys().deleteByPattern("system_relation_flow_statistics_2024-06-01*");
    }

    public static void hashHincrBy(RedissonClient client) {
        RMap<Object, Object> hash = client.getMap("hashTest", new StringCodec("utf-8"));
        hash.addAndGet("count", 10);
    }
}
