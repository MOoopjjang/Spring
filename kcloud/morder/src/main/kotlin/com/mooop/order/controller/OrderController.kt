package com.mooop.order.controller

import com.mooop.order.service.OrderService
import com.mooop.order.service.dto.OrderInfoDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.TimeoutException


@RestController
@RequestMapping("/morder")
class OrderController constructor(
    val orderService: OrderService
){

    val LOGGER = LoggerFactory.getLogger(OrderController::class.java)

    /**
     * 주문정보 ( one )
     */
    @GetMapping("/info/{id}")
    fun order(@RequestHeader("morder-req-key") seq:String? , @PathVariable id:Long ): Mono<OrderInfoDto> {
        LOGGER.info(">>> req-seq = {}" , seq)

        return  orderService.orderInfo(id)
    }

    /**
     * 주문정보 ( all )
     */
    @GetMapping("/infos")
    fun orders(@RequestHeader("morder-req-key") seq:String? ): Flux<OrderInfoDto> {
        LOGGER.info(">>> req-seq = {}" , seq)
        return orderService.orderAllInfo()
    }

    @GetMapping("/err/to")
    fun timeOut() : Mono<String> {
        throw TimeoutException("Test Exception")
    }
}