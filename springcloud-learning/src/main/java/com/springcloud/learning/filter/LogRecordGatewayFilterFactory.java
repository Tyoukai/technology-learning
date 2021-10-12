package com.springcloud.learning.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 日志相关的过滤器
 */
@Component
public class LogRecordGatewayFilterFactory extends AbstractGatewayFilterFactory<LogRecordGatewayFilterFactory.Config> {

    public LogRecordGatewayFilterFactory() {
        super(Config.class);
    }

    private static String REQUESR_BEGIN_TIME = "requestBeginTime";
    private static String RESPONSE_COOKIE_NAME = "rt-record";
    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            exchange.getAttributes().put(REQUESR_BEGIN_TIME, System.currentTimeMillis());

            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(REQUESR_BEGIN_TIME);
                        if (startTime != null) {
                            String cost = String.valueOf(System.currentTimeMillis() - startTime);
                            System.out.println("cost:" + cost);
                            exchange.getResponse().getCookies();
                        }
                    })
            );
        });
    }

    public static class Config {
        private String appKey;

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }
    }
}
