package com.mooop.rl.common.system

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.time.Duration

/**
 * Project: kmvc
 * Package :com.mooop.rl.common.system
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */
@Component
class RedisLockRepository constructor(
    val redisTemplate: RedisTemplate<String , Any>
) {

    /**
     * lock
     */
    fun lock(key:String):Boolean? =
        redisTemplate
            .opsForValue()
            .setIfAbsent(key , "lock" , Duration.ofMillis(3_000))

    /**
     * unlock
     */
    fun unlock(key:String):Boolean? = redisTemplate.delete(key)

}