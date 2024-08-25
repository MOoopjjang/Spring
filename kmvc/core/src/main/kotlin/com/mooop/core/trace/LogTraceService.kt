package com.mooop.core.trace

import com.mooop.core.trace.vo.ArrowType
import com.mooop.core.trace.vo.LogTraceInfo
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

/**
 * Project : kmvc
 * Package :com.mooop.core.trace
 * Author :  mooop
 * Date : 14/05/2022
 * Desc : Trace Log를 출력하는 class
 */
@Service("logTraceService")
class LogTraceService{

    private lateinit var logTraceHolder:LogTraceHolder
    @PostConstruct
    fun init(){
        logTraceHolder = LogTraceHolder()
    }


    /**
     * level에 맞는 trace log를 생성한다.
     */
    fun getTraceLog(methodName:String , arrow:ArrowType):String =
        logTraceHolder.get()!!.let { info->
            val sb:StringBuilder = StringBuilder("[${info.traceId}]")
            sb.append(getBoundary(info.level , arrow)).append(methodName)
            if(arrow == ArrowType.LEFT && info.level == 0){
                sb.append(">> time=${TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - info.start)} ms")
            }
            sb.toString()
        }




    fun incrementLevel(){
        logTraceHolder.get()?.apply { this.level = this.level.plus(1) }?:logTraceHolder.set(LogTraceInfo())
    }

    fun decrementLevel(){
        logTraceHolder.get()?.apply { this.level = this.level.minus(1) }
        if(logTraceHolder.get()!!.level == -1){
            logTraceHolder.remove()
        }
    }



    /**
     * Boundary를 생성한다.
     */
    private fun getBoundary(level:Int , arrow:ArrowType):String{
        var sb:StringBuilder = StringBuilder()
        for(i in 0 until level ){
            if(i == level-1){
                sb.append(arrow.code)
            }else{
                sb.append(ArrowType.SPACE.code)
            }
        }
        return sb.toString()
    }
}