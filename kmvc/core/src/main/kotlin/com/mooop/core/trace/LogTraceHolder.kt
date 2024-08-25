package com.mooop.core.trace

import com.mooop.core.trace.vo.LogTraceInfo

/**
 * Project : kmvc
 * Package :com.mooop.core.trace
 * Author :  mooop
 * Date : 14/05/2022
 * Desc :
 */
class LogTraceHolder {
    /**
     * LogTraceInfo를 저장한 객체
     */
    private val holder:ThreadLocal<LogTraceInfo> = ThreadLocal<LogTraceInfo>()


    fun set(info:LogTraceInfo):Unit = holder.set(info)

    fun set(level:Int):Unit{
        holder.get()?.apply { this.level = level }?:holder.set(LogTraceInfo())
    }

    fun get():LogTraceInfo? = holder.get()


    fun remove():Unit{
        if(holder.get() != null){
            holder.remove()
        }
    }


}