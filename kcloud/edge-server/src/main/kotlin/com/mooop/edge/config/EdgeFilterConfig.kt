package com.mooop.edge.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI
import java.util.*

/**
 * application.yml로 설정 이동...
 */
//@Configuration(proxyBeanMethods = false)
class EdgeFilterConfig {
//    @Bean
//    fun gwRoutes(routeLocatorBuilder:RouteLocatorBuilder) : RouteLocator =
//        routeLocatorBuilder.routes {
//            route {
//                path("/morder/**")
//                filters {
//                    addRequestHeader("morder-req-key" , UUID.randomUUID().toString())
//                    circuitBreaker{c->
//                        c.name = "orderCircuitBreaker"
//                        c.fallbackUri = URI("forward:/morder-fallback")
//                    }
//                }
//                uri("http://localhost:8089/")
//            }
//            route {
//                path("/mprod/**")
//                filters{
//                    addRequestHeader("mprod-req-key" , UUID.randomUUID().toString())
//                    circuitBreaker { c->
//                        c.name = "prodCircuitBreaker"
//                    }
//                }
//                uri("http://localhost:8087/")
//            }
//        }
}