package com.mooop.cache.service

import com.mooop.cache.vo.Cache
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * Project : kmvc
 * Package :com.mooop.cache.service
 * Author :  zinnaworks
 * Date : 11/04/2022
 * Desc :
 */
@Service
class CacheService {

    /**
     *  No Cache
     */
    fun t1():Cache{
        Thread.sleep(5000L)
        return Cache().apply {
            this.title = "hi"
            this.content = "안녕하세요~ 또 만났군요..다시는 못만나나 생각했줘~"
            this.id = 1
        }
    }


    /**
     * Redis Cache
     *
     *
     */
    @Cacheable(key = "#id" , value = ["t2"])
    fun t2(id:Long):Map<String , Any>{
        println("------->>>1")
        Thread.sleep(5000L)
        println("------->>>2")

        return mutableMapOf<String , Any>()
            .apply {
                this["title"] = "hello"
                this["content"] = "( cache 적용 )안녕하세요~ 또 만났군요..다시는 못만나나 생각했줘~"
                this["id"] = id
            }
    }


    @Cacheable(key="#id" , value = ["t3"])
    fun t3(id:Long):Cache{
        Thread.sleep(5000L)
        return Cache().apply {
            this.title = "t3"
            this.content = "(cache ) t3 body"
            this.id = id
        }
    }
}