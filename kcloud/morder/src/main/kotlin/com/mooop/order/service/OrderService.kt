package com.mooop.order.service

import com.mooop.order.repository.OrderRepository
import com.mooop.order.service.dto.OrderInfoDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class OrderService constructor(
    val orderRepository: OrderRepository
){


    /**
     * 주문정보 반환
     */
    fun orderInfo(id:Long): Mono<OrderInfoDto> =
        orderRepository.findByOne(id)
            .flatMap { o->
                if(o == null){
                    Mono.empty()
                }else{
                    Mono.just(OrderInfoDto(o.id , o.name , o.price))
                }
            }


    /**
     * 전체주문정보 반환
     */
    fun orderAllInfo(): Flux<OrderInfoDto> =
        orderRepository.findByAll()
            .map { o->
                OrderInfoDto( o!!.id , o!!.name , o!!.price)
            }

}