package com.wien.microservices.apigateway.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
                .build();
    }
}
