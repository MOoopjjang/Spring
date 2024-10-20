package com.mooop.edge.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono


@Configuration
class WebEndPoints {

    @Bean
    fun endPointRouter() = router {
        "/morder-fallback".nest {
            GET(""){
                ServerResponse.ok().body(Mono.just("morder server error") , String::class.java)
            }
        }
    }
}