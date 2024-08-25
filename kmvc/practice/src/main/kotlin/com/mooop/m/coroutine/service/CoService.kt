package com.mooop.m.coroutine.service

import org.springframework.stereotype.Service

/**
 * Project: kmvc
 * Package :com.mooop.m.coroutine.service
 * Author : mooopjjang
 * Date 2023/02/26
 * DESC :
 */
@Service
class CoService {


    suspend fun t1():String{
        println("T1 ---> start")
        Thread.sleep(3*1000L)
        println("T1 ---> end")
        return "T1"
    }


    suspend fun t2():String{
        println("T2 ---> start")
        println("T2 ---> end")
        return "T2"
    }


    suspend fun t3():String{
        println("T3 ---> start")
        Thread.sleep(10*1000L)
        println("T3 ---> end")
        return "T3"
    }

}