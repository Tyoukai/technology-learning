package com.springcloud.learning.filter.global;

import com.springcloud.learning.others.GlobalFilterOrderEnum;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * grpc路由filter，用于将请求转发到具体的grpc服务
 */
@Component
public class GrpcRouteFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return GlobalFilterOrderEnum.GRPC_ROUTE.getOrder();
    }
}
