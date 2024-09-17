package com.mooop.mprod.repository

import com.mooop.mprod.repository.entity.ProductItem
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Repository
class ProductionRepository {

    companion object {
        var productions = listOf(
            ProductItem(1,"ICE Americano" , 3000,null)
            ,ProductItem(2,"ICE Latte" , 5500,null)
            ,ProductItem(3,"Banana Juice" , 4000,"생과일 쥬스")
            ,ProductItem(4,"Milk" , 3500,"목장에 순수한 우유")
        )
    }


    suspend fun findById(id:Long) = productions.first { p->p.id==id }

    suspend fun findByAll() = productions
}