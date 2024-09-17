package com.mooop.mprod.handler

import com.mooop.mprod.handler.dto.ProductItemRes
import com.mooop.mprod.repository.ProductionRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyValueAndAwait


@Component
class ProductionHandler constructor(
    val productionRepository: ProductionRepository
){

    /**
     * 상품정보 ( one )
     */
    suspend fun productItem(request:ServerRequest) : ServerResponse =
        request.pathVariable("id").toLong().let { id->
            ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValueAndAwait(
                    productionRepository.findById(id)
                        .let { e-> ProductItemRes("OK" , e.id , e.itemName , e.itemPrice , e.itemComment)
                        }
                )
        }

    /**
     * 상품정보 ( 전체 )
     */
    suspend fun productItems():ServerResponse =
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(
                productionRepository.findByAll().map {e->
                        ProductItemRes("OK" ,e.id , e.itemName , e.itemPrice , e.itemComment)
                }
            )
}