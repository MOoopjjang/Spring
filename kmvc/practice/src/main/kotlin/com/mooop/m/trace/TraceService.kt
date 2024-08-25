package com.mooop.m.trace

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

/**
 * Project : kmvc
 * Package :com.mooop.m.trace
 * Author :  mooop
 * Date : 15/05/2022
 * Desc :
 */
@Profile(value = ["trace"])
@Service
class TraceService {

    fun serviceT1():Map<String , String> = mapOf(Pair("name" , "cwkim") , Pair("age" , "20"))

    fun serviceError():Map<String , String>{
        val m:MutableMap<String , String>? = null
        m!!["name"] = "xferlog"
        return m
    }
}