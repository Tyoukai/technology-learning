package redis;

import com.google.common.collect.Lists;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RedissonDemo {
    public static void main(String[] args) {
        Config config = new Config();
//        config.useReplicatedServers()
//                .addNodeAddress("redis://172.16.123.188:6379");
//                .setPassword("1234_rewq");

//        config.useSentinelServers()
//                .setMasterName("mymaster")
//                .setPassword("1234rewq")
//                .setSentinelAddresses(Lists.newArrayList("redis://172.16.66.14:26379", "redis://172.16.66.17:26379", "redis://172.16.66.18:26379"));
//        .setSentinelAddresses(Lists.newArrayList("redis://172.19.184.206:26379", "redis://172.19.184.207:26379"));

//        config = Config.fromYAML(new File("config-file.yaml"));
        config.useMasterSlaveServers()
                .setMasterAddress("redis://172.16.66.17:6379")
                .setPassword("1234rewq")
                .addSlaveAddress("redis://172.16.66.14:6379", "redis://172.16.66.18:6379");
        RedissonClient client = Redisson.create(config);

//        string(client);
        hash((client));
//        hashHincrBy(client);



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

    public static void hashHincrBy(RedissonClient client) {
        RMap<Object, Object> hash = client.getMap("hashTest", new StringCodec("utf-8"));
        hash.addAndGet("count", 10);
    }
}
