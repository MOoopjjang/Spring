package com.mooop.m.trace

import com.mooop.core.trace.BasicLogTraceAspect
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Project : kmvc
 * Package :com.mooop.m.trace
 * Author :  mooop
 * Date : 15/05/2022
 * Desc :
 */
@Profile(value = ["trace"])
@Component
@Aspect
class LogTraceAspect : BasicLogTraceAspect(){
    @Pointcut("execution (* com.mooop.m..*(..))")
    override fun range() {}
}