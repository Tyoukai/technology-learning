package com.springcloud.learning.filter.global;

import com.springcloud.learning.others.GlobalFilterOrderEnum;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 参数映射的Filter
 * 在http->grpc或grpc->http时进行参数映射
 */
@Component
public class ParameterMappingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return GlobalFilterOrderEnum.PARAMETER_MAPPING.getOrder();
    }
}
