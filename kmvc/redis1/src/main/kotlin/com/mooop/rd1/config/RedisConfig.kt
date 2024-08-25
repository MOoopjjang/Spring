package com.mooop.rd1.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * Project: kmvc
 * Package :com.mooop.rd1.config
 * Author : mooopjjang
 * Date 2023/09/24
 * DESC :
 */
@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionnFactory() : RedisConnectionFactory = LettuceConnectionFactory()

    @Bean
    fun redisTemplate():RedisTemplate<String , Any> =
        RedisTemplate<String , Any>().apply {
            this.setConnectionFactory(redisConnectionnFactory())

            this.keySerializer = StringRedisSerializer()
            this.valueSerializer = Jackson2JsonRedisSerializer(Any::class.java)

            this.hashKeySerializer = StringRedisSerializer()
            this.hashValueSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        }
}