package com.mooop.m

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Project : kmvc
 * Package :com.mooop.api
 * Author :  zinnaworks
 * Date : 08/04/2022
 * Desc :
 */
@SpringBootApplication
class ApiApplication

fun main(args:Array<String>){
    runApplication<ApiApplication>(*args)
}