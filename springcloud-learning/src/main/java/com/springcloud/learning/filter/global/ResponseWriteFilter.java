package com.springcloud.learning.filter.global;

import com.springcloud.learning.others.GlobalFilterOrderEnum;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * response回写filter，在真正转发时，重写response
 */
@Component
public class ResponseWriteFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return GlobalFilterOrderEnum.RESPONSE_WRITE.getOrder();
    }
}
