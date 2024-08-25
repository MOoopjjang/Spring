package com.mooop.rd1.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisConnectionUtils
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

/**
 * Project: kmvc
 * Package :com.mooop.rd1.controller
 * Author : mooopjjang
 * Date 2023/09/24
 * DESC :
 */

@RestController
@RequestMapping("/rd")
class RedisController {

    val logger = LoggerFactory.getLogger(RedisController::class.java)

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String , Any>



    @PostMapping("/t1")
    fun t1(@RequestBody param:MutableMap<String , Any>) : Map<String , Any>{
        logger.info(">>> param = {}" , param.toString())
        val hashOperations:HashOperations<String , Any , Any> = redisTemplate.opsForHash()

        hashOperations.put("T1" , param["id"] as String , param)





        return mutableMapOf("name" to "xferlog" , "age" to 10)
    }
}