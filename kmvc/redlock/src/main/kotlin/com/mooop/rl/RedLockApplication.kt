package com.mooop.rl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Project: kmvc
 * Package :com.mooop.rl
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */
@SpringBootApplication
class RedLockApplication

fun main(args:Array<String>){
    runApplication<RedLockApplication>(*args)
}