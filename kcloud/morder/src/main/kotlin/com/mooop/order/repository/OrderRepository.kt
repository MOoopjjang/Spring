package com.mooop.order.repository

import com.mooop.order.repository.entity.OrderEntity
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class OrderRepository {

    companion object{
        val orders = listOf(
            OrderEntity(1,"A00001" , "ICE Americano" , 3000 , 100)
            ,OrderEntity(2,"A00002" , "ICE Latte" , 4500 , 50)
            ,OrderEntity(3,"A00003" , "Banana Juice" , 5000 , 30)
            ,OrderEntity(4,"A00004" , "Hot Latte" , 4500 , 70)
        )
    }

    fun findByOne(id:Long): Mono<OrderEntity?> =
        Mono.fromCallable {
            val l = orders.filter { oe->oe.id == id }
            if( l.isNotEmpty() ){
                l.first()
            }else{
                null
            }

        }

    fun findByAll(): Flux<OrderEntity?> =
        Flux.fromIterable(orders)

}