package com.mooop.cache.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * Project : kmvc
 * Package :com.mooop.cache.config
 * Author :  zinnaworks
 * Date : 10/04/2022
 * Desc :
 */
@Configuration
class CacheConfig constructor( val redisConnectionFactory:RedisConnectionFactory
 , val objectMapper:ObjectMapper){


    @Bean
    fun cacheManager(): CacheManager =
        RedisCacheConfiguration.defaultCacheConfig().let{
            it.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
            it.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                GenericJackson2JsonRedisSerializer(objectMapper)))
            RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
                .cacheDefaults(it)
                .build()
        }



}