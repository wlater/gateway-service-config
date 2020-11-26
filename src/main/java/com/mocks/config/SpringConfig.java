package com.mocks.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/user/**")
                        .uri("lb://TER-SERVICE/")
                        .id("userModule"))
                .route(r -> r.path("/api/v1/key/**")
                        .uri("lb://TER-SERVICE/")
                        .id("encryptModule"))
                .build();
    }

}
