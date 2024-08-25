package com.mooop.core.trace

import com.mooop.core.trace.vo.ArrowType
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.springframework.beans.factory.annotation.Autowired

/**
 * Project : kmvc
 * Package :com.mooop.core.trace
 * Author :  mooop
 * Date : 14/05/2022
 * Desc : Log를 추적하는 aspect
 */
abstract class BasicLogTraceAspect {

    @Autowired
    lateinit var logTraceService: LogTraceService

    abstract fun range()

    @Around("range()")
    fun logTrace(joinPointer:ProceedingJoinPoint):Any{
        val methodName = joinPointer.signature.toShortString()
        try{
            logTraceService.incrementLevel()
            println(logTraceService.getTraceLog(methodName , ArrowType.RIGHT))
            val ret = joinPointer.proceed()
            println(logTraceService.getTraceLog(methodName , ArrowType.LEFT))
            logTraceService.decrementLevel()
            return ret
        }catch (e:Exception){
            println(logTraceService.getTraceLog(methodName , ArrowType.ERROR))
            logTraceService.decrementLevel()
            throw e
        }
    }
}