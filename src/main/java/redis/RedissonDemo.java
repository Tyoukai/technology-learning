package redis;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;


public class RedissonDemo {
    public static void main(String[] args) {
        Config config = new Config();
        config.useReplicatedServers()
                .addNodeAddress("redis://101.43.59.148:6379")
                .setPassword("hust123456");

//        config = Config.fromYAML(new File("config-file.yaml"));
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
        hash.put("expireTime", "1638692010000");
        hash.put("count", "100");
        int count = Integer.parseInt(hash.addAndGet("count", 100).toString());
        System.out.println(count);
        System.out.println("未设置过期时间:" + hash.remainTimeToLive());

        RMap<Object, Object> remainTimeToLive = client.getMap("remainTimeToLive", new StringCodec("utf-8"));
        remainTimeToLive.put("1", "1");
        remainTimeToLive.expireAt(System.currentTimeMillis() + 100000);
        System.out.println("设置了过期时间：" + remainTimeToLive.remainTimeToLive());
        System.out.println("key不存在过期时间：" + client.getMap("12233").remainTimeToLive());

        // 查看key是否存在
        System.out.println(client.getMap("isExists", new StringCodec("utf-8")).isExists());




    }

    public static void hashHincrBy(RedissonClient client) {
        RMap<Object, Object> hash = client.getMap("hashTest", new StringCodec("utf-8"));
        hash.addAndGet("count", 10);
    }
}
