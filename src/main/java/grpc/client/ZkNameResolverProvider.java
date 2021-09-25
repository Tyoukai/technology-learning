package grpc.client;

import java.net.URI;

import javax.annotation.Nullable;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.NameResolver.Args;
import io.grpc.NameResolverProvider;

/**
 * 服务发现的策略
 *
 * @author zhangkwei <zhangkewei@kuaishou.com>
 * Created on 2021-06-26
 */
public class ZkNameResolverProvider extends NameResolverProvider {

    // 服务的名称
    private String serviceName;

    public ZkNameResolverProvider(String serviceName) {
        this.serviceName = serviceName;
    }

    // 服务是否可用
    @Override
    protected boolean isAvailable() {
        return true;
    }

    // 优先级
    @Override
    protected int priority() {
        return 0;
    }

    // 使用的协议
    @Override
    public String getDefaultScheme() {
        return "zk";
    }

    // 服务发现类
    @Nullable
    @Override
    public NameResolver newNameResolver(URI targetUri, Attributes params) {
        return new ZkNameResolver(targetUri, serviceName);
    }

}
