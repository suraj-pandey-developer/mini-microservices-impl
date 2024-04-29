package com.cloud.gateway.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class MyPreFilter implements GlobalFilter {

    private final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info(" filter() method execution started ......");

        // ACCEss request INformation

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        Set<String> keySet = headers.keySet();

        keySet.forEach(key-> {
            List<String> values = headers.get(key);    // for each key multiple headers key can be there
            System.out.println(key +" = ......" +  values);
        });
        return chain.filter(exchange);
    }
}
