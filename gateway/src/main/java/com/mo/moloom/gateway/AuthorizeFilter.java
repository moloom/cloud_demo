package com.mo.moloom.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author moloom
 * @date 2023-10-10 23:47
 * @description @Order定义filter的优先级，值越大优先级越低
 */
@Order(-1)
@Component
public class AuthorizeFilter implements GlobalFilter {
    /**
     * @param exchange 请求上下文，里面可以获取Request、Response等信息
     * @param chain    用来把请求委托给下一个过滤器
     * @return {@link Mono<Void>} 返回标示当前过滤器业务结束
     * @author moloom
     * @date 2023-10-10 23:48:47
     * @description 处理当前请求，有必要的话通过{@link GatewayFilterChain}将请求交给下一个过滤器处理
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1.获取请求参数
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
        // 2.获取authorization参数
        String auth = params.getFirst("authorization");
        // 3.校验
        if ("admin".equals(auth)) {
            // 放行
            return chain.filter(exchange);
        }
        // 4.拦截
        // 4.1.禁止访问，设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        // 4.2.结束处理
        return exchange.getResponse().setComplete();
    }
}
