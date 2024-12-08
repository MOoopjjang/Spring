package com.mooop.dispatcherservice.functions

import com.mooop.dispatcherservice.dto.OrderAcceptedMessage
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import java.util.function.Function


@Configuration
class DispatchingFunctions {

    val logger = LoggerFactory.getLogger(DispatchingFunctions::class.java)

    // Bean으로 정의된 함ㅅ는 스프링 클랑드 함수가 찾아서관리할수 있다.
    @Bean
    fun pack():Function<OrderAcceptedMessage, Long>{
        return Function { orderAcceptedMessage->
            logger.info(">>> pack() : {} --> " , orderAcceptedMessage.orderId)
            orderAcceptedMessage.orderId
        }
    }


    @Bean
    fun label():Function<Flux<Long> , Flux<OrderAcceptedMessage>>{
        return Function{ orderFlux->
                orderFlux.map { orderId->
                    logger.info(">>> label() : {} -->",orderId)
                    OrderAcceptedMessage(orderId)
                }
        }
    }
}