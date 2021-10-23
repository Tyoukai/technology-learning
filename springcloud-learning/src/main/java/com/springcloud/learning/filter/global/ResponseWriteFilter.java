package com.springcloud.learning.filter.global;

import com.springcloud.learning.others.GlobalFilterOrderEnum;
import io.netty.util.CharsetUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.springcloud.learning.others.GlobalFilterOrderEnum.RESPONSE_WRITE;
import static com.springcloud.learning.utils.Constants.OUTPUT_JSON_STRING;

/**
 * response回写filter，在真正转发时，重写response
 */
@Component
public class ResponseWriteFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ResponseWriteServerHttpResponseDecorator decorator =
//                new ResponseWriteServerHttpResponseDecorator(exchange);
//
//        return chain.filter(exchange).then(Mono.defer(() -> {
//            exchange.mutate().response(decorator).build();
//            return Mono.empty();
//        }));



        return chain.filter(exchange).then(Mono.defer(() -> {
            String result = (String) exchange.getAttributes().get(OUTPUT_JSON_STRING);
            byte[] byteResult = result.getBytes(CharsetUtil.UTF_8);
            ServerHttpResponse response = exchange.getResponse();
            DataBuffer dataBuffer = response.bufferFactory().allocateBuffer(byteResult.length).write(byteResult);
            return response.writeWith(Flux.just(dataBuffer));
        }));
    }

    @Override
    public int getOrder() {
        //WRITE_RESPONSE_FILTER 之前执行
//        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER - 1;
        return RESPONSE_WRITE.getOrder();
    }
}
