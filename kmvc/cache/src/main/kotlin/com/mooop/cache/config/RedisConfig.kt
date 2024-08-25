package com.mooop.cache.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * Project : kmvc
 * Package :com.mooop.cache.config
 * Author :  zinnaworks
 * Date : 10/04/2022
 * Desc :
 */
@Configuration
class RedisConfig {

    @Value("\${spring.redis.port}")
    lateinit var port:Integer

    @Value("\${spring.redis.host}")
    lateinit var host:String

    @Autowired
    lateinit var objectMapper:ObjectMapper


    @Bean
    fun redisTemplate(redisConnectionFactory:RedisConnectionFactory):RedisTemplate<String , Object> =
        RedisTemplate<String , Object>()
            .apply {
                this.keySerializer = StringRedisSerializer()
                this.valueSerializer = GenericJackson2JsonRedisSerializer()
                this.setConnectionFactory(redisConnectionFactory)
            }



    @Bean
    fun redisConnectionFactory():RedisConnectionFactory =
        RedisStandaloneConfiguration()
            .let {
                it.hostName = host
                it.port = port.toInt()
                LettuceConnectionFactory(it)
            }
}