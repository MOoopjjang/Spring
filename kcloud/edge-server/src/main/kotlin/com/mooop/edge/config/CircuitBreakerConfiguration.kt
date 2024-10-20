package com.mooop.edge.config

//import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
//import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
//import io.github.resilience4j.timelimiter.TimeLimiterConfig
//import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory
//import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder
import org.springframework.cloud.client.circuitbreaker.Customizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

/**
 * application.yml로 설정 이동
 */
//@Configuration
class CircuitBreakerConfiguration {

//    @Bean
//    fun circuitBreakerRegistry():CircuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfiguration())
//
//    private fun circuitBreakerConfiguration(): CircuitBreakerConfig  = CircuitBreakerConfig.custom()
//        .failureRateThreshold(40F)       //실패율 임계닶 ( 백분율 단위)
//        .waitDurationInOpenState(Duration.ofMillis(15000))      //Open -> half-open으로 전환되기 전에 대기시간
//        .permittedNumberOfCallsInHalfOpenState(3)                     // half-open시 허용되는 호출수
//        .slidingWindowSize(10)                                         //호출 결과를 기록하는데 사용되는 슬라이딩 윈도우 크기
//        .recordExceptions(RuntimeException::class.java)                 //실패로 기록되어 실패율이 증가하는 예외 목록
//        .build()


/*
    @Bean
    fun defaultCustomizer() : Customizer<ReactiveResilience4JCircuitBreakerFactory> =
        Customizer<ReactiveResilience4JCircuitBreakerFactory>{f->
            f.configureDefault { id->
                Resilience4JConfigBuilder(id).circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                    .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4))
                        .build())
                    .build()
            }
        }
*/



}