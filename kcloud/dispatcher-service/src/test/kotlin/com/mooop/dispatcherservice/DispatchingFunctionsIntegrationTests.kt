package com.mooop.dispatcherservice

import com.mooop.dispatcherservice.dto.OrderAcceptedMessage
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.function.context.FunctionCatalog
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.util.function.Function

@FunctionalSpringBootTest
class DispatchingFunctionsIntegrationTests {

    @Autowired
    lateinit var catalog:FunctionCatalog


    @Test
    fun packAndLabelOrder(){
        val packAndLabel:Function<OrderAcceptedMessage , Flux<OrderAcceptedMessage>> =
            catalog.lookup(
                Function::class.java
                ,"pack|label"
            )
        val orderId:Long = 121

        StepVerifier.create(packAndLabel.apply(OrderAcceptedMessage(orderId)))  //함수에 대한 입력인 OrderAcceptedMessage 를 정의한다.
            .expectNextMatches { dispatchOrder->                                // 함수의 출력이 OrderDispatchedMessage 객체인지 확인한다.
                dispatchOrder == OrderAcceptedMessage(orderId)
            }.verifyComplete()
    }
}