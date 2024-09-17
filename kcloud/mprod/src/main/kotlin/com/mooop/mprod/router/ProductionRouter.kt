package com.mooop.mprod.router

import com.mooop.mprod.handler.ProdHandlerFilterFunction
import com.mooop.mprod.handler.ProductionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter


@Configuration
class ProductionRouter constructor(
    val productionHandler: ProductionHandler
    ,val prodHandlerFilterFunction: ProdHandlerFilterFunction
){

    @Bean
   fun apiRouter() = coRouter {
        "/mprod".nest {
            GET("/info/{id}"){
                productionHandler.productItem(it)
            }
            GET("/infos"){
                productionHandler.productItems()
            }
        }
   }
       .filter(prodHandlerFilterFunction)

}