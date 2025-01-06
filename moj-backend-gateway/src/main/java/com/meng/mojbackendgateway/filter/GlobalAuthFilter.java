package com.meng.mojbackendgateway.filter;

import cn.hutool.core.text.AntPathMatcher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * TODO 实现限流降级 参考：https://sca.aliyun.com/docs/2021/user-guide/sentinel/overview/
 * @DESCRIPTION: 解决权限校验：一些内部接口不能直接被访问
 * @AUTHOR: MENGLINGQI
 * @TIME: 2025/1/6 22:27
 **/
public class GlobalAuthFilter implements GlobalFilter, Ordered {
    // 路径匹配器
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    /**
     * @description:  权限校验方法
     * @param[1] exchange
     * @param[2] chain
     * @throws:
     * @return:
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String path = serverHttpRequest.getURI().getPath();
        if (antPathMatcher.match("/**/inner/**", path)){
            ServerHttpResponse serverHttpResponse = exchange.getResponse();
            serverHttpResponse.setStatusCode(HttpStatus.FORBIDDEN);
            DataBufferFactory dataBufferFactory = serverHttpResponse.bufferFactory();
            DataBuffer dataBuffer = dataBufferFactory.wrap("无权限".getBytes());
            return serverHttpResponse.writeWith(Mono.just(dataBuffer));
        }
        return chain.filter(exchange);
    }

    /**
     * @description: 过滤器优先级，将该过滤器优先级提到最高。防止后期多个过滤器调用，浪费性能。
     * @throws:
     * @return:
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
