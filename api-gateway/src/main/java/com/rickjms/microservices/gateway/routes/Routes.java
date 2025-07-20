package com.rickjms.microservices.gateway.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class Routes {

        @Bean
        public RouterFunction<ServerResponse> productServiceRoutes() {
                System.out.println("Routes.productServiceRoutes()");
                return route()
                                .route(path("/api/product"),
                                                req -> ServerResponse.temporaryRedirect(
                                                                java.net.URI.create(
                                                                                "http://localhost:8080" + req.path()))
                                                                .build())
                                .route(path("/api/inventory"),
                                                req -> ServerResponse.temporaryRedirect(
                                                                java.net.URI.create(
                                                                                "http://localhost:8082" + req.path()))
                                                                .build())
                                .route(path("/api/order"),
                                                req -> ServerResponse.temporaryRedirect(
                                                                java.net.URI.create(
                                                                                "http://localhost:8081" + req.path()))
                                                                .build())
                                .build();
        }
}
