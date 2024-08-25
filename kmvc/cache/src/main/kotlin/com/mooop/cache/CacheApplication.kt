package com.mooop.cache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

/**
 * Project : kmvc
 * Package :com.mooop.cache
 * Author :  zinnaworks
 * Date : 10/04/2022
 * Desc :
 */
@EnableCaching
@SpringBootApplication
class CacheApplication


fun main(args:Array<String>){
    runApplication<CacheApplication>(*args)
}