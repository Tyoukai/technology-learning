package com.springcloud.learning.filter;

import com.google.common.collect.Lists;
import io.netty.util.CharsetUtil;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sun.misc.IOUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
            MultiValueMap<String, String> map = exchange.getRequest().getQueryParams();

            return chain.filter(exchange).then(
                    Mono.defer(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Long startTime = exchange.getAttribute(REQUESR_BEGIN_TIME);
                        String cost = String.valueOf(System.currentTimeMillis() - startTime);
                        System.out.println("cost:" + cost);
                        String responseCost = "cost: " + cost;
                        byte[] byteResponseCost = responseCost.getBytes(CharsetUtil.UTF_8);
                        ServerHttpResponse response = exchange.getResponse();
                        DataBuffer buffer = response.bufferFactory().allocateBuffer(byteResponseCost.length).write(byteResponseCost);
                        return response.writeWith(Flux.just(buffer));
                    }).timeout(Duration.ofSeconds(1))
            );

//            ServerHttpResponseDecorator decorator = new ServerHttpResponseDecorator(exchange.getResponse()) {
//
//                @Override
//                public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
//                    if (getStatusCode().equals(HttpStatus.OK) && body instanceof Flux) {
//
//                        Flux<? extends DataBuffer> fluxBody = Flux.from(body);
//                        return super.writeWith(fluxBody.buffer().map(dataBuffers -> {
//                            List<String> list = Lists.newArrayList();
//
//                            dataBuffers.forEach(dataBuffer -> {
//                                byte[] content = new byte[dataBuffer.readableByteCount()];
//                                dataBuffer.read(content);
//                                DataBufferUtils.release(dataBuffer);
//
//                                try {
//                                    list.add(new String(content, "utf-8"));
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            });
//                            String s = joiner.join(list);
//                            try {
//                                if (!WrapMapper.isWrap(s)) {
//                                    s = objectMapper.writeValueAsString(WrapMapper.ok(objectMapper.readValue(s, Object.class)));
//                                }
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println(s);
//                            return bufferFactory().wrap(s.getBytes());
//                        }));
//                    }
//                    return super.writeWith(body);
//                }
//            };
//
//            return chain.filter(exchange.mutate().response(decorator).build());

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
