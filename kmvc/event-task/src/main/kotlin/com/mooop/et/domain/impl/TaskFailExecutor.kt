package com.mooop.et.domain.impl

import com.mooop.et.domain.BasicTaskExecutor
import com.mooop.et.domain.model.EventJobModel

class TaskFailExecutor<T> : BasicTaskExecutor<T>() {

    val failWorker = {
        while(!isStop){
            val task = queue.take()
            try{
                println("################ TaskFailExecutor ###############")
                val body = task.body
                println(">>>> TaskFailExecutor = ${body}")
                println("################################# ###############")
            }catch (ex:Exception){
                println(">>>>>> TaskFailExecutor fail = ${ex.message}")
            }
        }
    }
    val worker:Thread = Thread(failWorker)

    override fun add(job: EventJobModel<T>) {
        queue.add(job)
    }

    override fun execute() {
        if(!worker.isAlive){
            worker.start()
        }else{
            println("already TaskFailExecutor running!!!")
        }
    }

    override fun isQueueFull(): Boolean  = false

}