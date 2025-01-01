package com.mooop.et.domain

import com.mooop.et.domain.model.EventJobModel
import com.mooop.et.domain.model.EventResModel
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.properties.Delegates

open abstract class BasicTaskExecutor<T> {

    @Volatile protected var isStop:Boolean = false
    /** Blocking Queue */
    protected val queue:BlockingQueue<EventJobModel<T>> = LinkedBlockingQueue()

    abstract fun add(job: EventJobModel<T>)

    abstract fun execute()

    abstract fun isQueueFull():Boolean

    fun stop(){
        this.isStop = true
    }
}