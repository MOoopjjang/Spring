package com.mooop.core.trace.vo

import java.util.*

/**
 * Project : kmvc
 * Package :com.mooop.core.trace
 * Author :  mooop
 * Date : 14/05/2022
 * Desc :
 */
class LogTraceInfo {
    val traceId:String = UUID.randomUUID().toString().replace("-" , "")
    var level:Int = 0
    val start:Long = System.nanoTime()
}