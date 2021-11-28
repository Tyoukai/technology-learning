package redis;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
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

        RBucket<String> bucket = client.getBucket("test", new StringCodec("utf-8"));
        bucket.set("value");

        String valueInRedis = bucket.get();
        System.out.println(valueInRedis);

    }
}
