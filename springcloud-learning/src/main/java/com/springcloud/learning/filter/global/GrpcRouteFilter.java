package com.springcloud.learning.filter.global;

import com.springcloud.learning.others.GlobalFilterOrderEnum;
import com.springcloud.learning.utils.GrpcUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

import java.util.List;
import java.util.Random;

import static com.springcloud.learning.utils.Constants.*;

/**
 * grpc路由filter，用于将请求转发到具体的grpc服务
 * 1、根据匹配的path获取到对应path的uri
 * 2、根据uri到zk上获取对应服务的ip和port
 * 3、调用grpc相关的反射组件获取对应的服务
 * 4、调用相关的grpc服务
 * 5、将调用的结果写入exchange中的attribute的GRPC_EXE_JSON_STRING中
 */
@Component
public class GrpcRouteFilter implements GlobalFilter, Ordered {

    private CuratorFramework curatorClient;

    @PostConstruct
    public void init() {
        curatorClient = CuratorFrameworkFactory.builder()
                .connectString("42.192.49.234:2181")
                .connectionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();

        curatorClient.start();
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Pair<String, String> metaData = getServiceName(exchange);
        Pair<String, String> serviceMetaData = getMethodMetaData(metaData);

        String request = (String) exchange.getAttributes().get(INPUT_JSON_STRING);
        int index = serviceMetaData.getLeft().lastIndexOf(SPLIT_COLON);
        String ip = serviceMetaData.getLeft().substring(0, index);
        String port = serviceMetaData.getLeft().substring(index + 1);

        String response = GrpcUtils.grpcGeneralizedCall(ip, port, request, serviceMetaData.getRight());
        exchange.getAttributes().put(GRPC_EXE_JSON_STRING, response);
        return chain.filter(exchange);
    }

    /**
     * 获取对应的grpc服务对应的名称
     * left -> zk上服务对应的全路径
     * right -> 具体的方法名称
     *
     * @param exchange
     * @return
     */
    private Pair<String, String> getServiceName(ServerWebExchange exchange) {
        Route route = (Route) exchange.getAttributes().get(FILTER_CONFIG_NAME);
        if (route == null) {
            return null;
        }
        String fullMethodName = route.getUri().getPath();
        String methodName = fullMethodName.substring(fullMethodName.lastIndexOf('/') + 1);
        String serviceName = fullMethodName.substring(0, methodName.lastIndexOf('/'));
        return Pair.of(serviceName, methodName);
    }

    /**
     * 获取具体方法的元数据
     * left -> ip:port
     * right -> 全限定方法名称
     *
     * @param metaData
     * @return
     */
    private Pair<String, String> getMethodMetaData(Pair<String, String> metaData) {
        try {
            List<String> serviceIpAndPortList = curatorClient.getChildren().forPath(metaData.getLeft());
            if (CollectionUtils.isEmpty(serviceIpAndPortList)) {
                return Pair.of(null, null);
            }
            // 随机获取一个ip访问
            Random random = new Random();
            String ipAndPort = serviceIpAndPortList.get(random.nextInt(serviceIpAndPortList.size()));
            String fullMethodNames = new String(curatorClient.getData().forPath(metaData.getLeft()));

            String[] fullMethodNameArray = fullMethodNames.split(SPLIT_COMMA);
            for (String fullMethodName : fullMethodNameArray) {
                if (metaData.getRight().equals(fullMethodName.substring(fullMethodName.lastIndexOf(SPLIT_POINT) + 1))) {
                    return Pair.of(ipAndPort, fullMethodName);
                }
            }

            return Pair.of(null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return Pair.of(null, null);
        }
    }

    @Override
    public int getOrder() {
        return GlobalFilterOrderEnum.GRPC_ROUTE.getOrder();
    }
}
