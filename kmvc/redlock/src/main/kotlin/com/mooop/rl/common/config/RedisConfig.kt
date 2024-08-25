package com.mooop.rl.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * Project: kmvc
 * Package :com.mooop.rl.common.config
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */
@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionFactory():RedisConnectionFactory = LettuceConnectionFactory()

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> =
        RedisTemplate<String , Any>().apply {
            this.setConnectionFactory(redisConnectionFactory())

            this.keySerializer = StringRedisSerializer()
            this.valueSerializer = Jackson2JsonRedisSerializer(Map::class.java)

            this.hashKeySerializer = StringRedisSerializer()
            this.hashValueSerializer = Jackson2JsonRedisSerializer(Map::class.java)

        }
}