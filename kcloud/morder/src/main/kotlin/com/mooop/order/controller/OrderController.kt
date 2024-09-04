package com.mooop.order.controller

import com.mooop.order.service.OrderService
import com.mooop.order.service.dto.OrderInfoDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/morder")
class OrderController constructor(
    val orderService: OrderService
){

    /**
     * 주문정보 ( one )
     */
    @GetMapping("/info/{id}")
    fun order(@PathVariable id:Long ): Mono<OrderInfoDto> = orderService.orderInfo(id)

    /**
     * 주문정보 ( all )
     */
    @GetMapping("/infos")
    fun orders(): Flux<OrderInfoDto> = orderService.orderAllInfo()


}