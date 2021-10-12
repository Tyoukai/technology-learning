package com.springcloud.learning.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * grpc 泛化调用过滤器
 */
//@Component
public class GrpcRouteGatewayFilterFactory extends AbstractGatewayFilterFactory<GrpcRouteGatewayFilterFactory.Config> {

    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {

            return chain.filter(exchange);
        });

    }

    public static class Config {

    }
}
