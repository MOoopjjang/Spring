package com.mooop.mprod.handler

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.HandlerFilterFunction
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class ProdHandlerFilterFunction : HandlerFilterFunction<ServerResponse, ServerResponse> {
    val LOGGER = LoggerFactory.getLogger(ProdHandlerFilterFunction::class.java)

    override fun filter(request: ServerRequest, next: HandlerFunction<ServerResponse>): Mono<ServerResponse> {
       LOGGER.info(">>> ProdHandlerFilterFunction")
        /**
         * edge-server를 통해 접근하지않을시 403 반환
         */
       return request.headers().firstHeader("mprod-req-key")?.let {
           next.handle(request)
       }?:ServerResponse.status(HttpStatus.FORBIDDEN)
           .body(BodyInserters.fromValue(mapOf("code" to "403" , "message" to "잘못된접근 경로입니다.")))
    }
}