package com.mooop.edge.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration(proxyBeanMethods = false)
class EdgeFilterConfig {
    @Bean
    fun gwRoutes(routeLocatorBuilder:RouteLocatorBuilder) : RouteLocator =
        routeLocatorBuilder.routes {
            route {
                path("/morder/**")
                filters {
                    addRequestHeader("morder-req-key" , UUID.randomUUID().toString())
                }
                uri("http://localhost:8089/")
            }
            route {
                path("/mprod/**")
                filters{
                    addRequestHeader("mprod-req-key" , UUID.randomUUID().toString())
                }
                uri("http://localhost:8087/")
            }
        }
}