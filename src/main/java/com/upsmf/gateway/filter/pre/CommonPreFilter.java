package com.upsmf.gateway.filter.pre;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CommonPreFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {
        log.debug("Global Pre Filter executed || Request - {} ", exchange.getRequest());
        log.debug("Global Pre Filter executed || Request Headers - {} ", exchange.getRequest().getHeaders());
        log.info("Global Pre Filter executed || Path - {} ", exchange.getRequest().getPath().value());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

}

