package com.mooop.et.domain.impl

import com.mooop.et.domain.BasicTaskExecutor
import com.mooop.et.domain.TaskFailInterface
import com.mooop.et.domain.enums.EventActionType
import com.mooop.et.domain.model.EventJobModel

class TaskRunExecutor<T> : BasicTaskExecutor<T>() , TaskFailInterface<T> {
    private val MAX_QUEUE_SIZE:Int = 10
    private lateinit var failCb:(EventJobModel<T>)->Unit?
    val runJob = {
        while(!isStop){
            val task = queue.take()
            try{
                println(">>>TaskRunExecutor job = ${task.body} - >action = ${task.actionType}")
                Thread.sleep(2000)
            }catch (e:Exception){
                println("e = ${e.message}")
                failCb(task)
            }
        }
    }
    private val worker:Thread by lazy { Thread(runJob) }



    override fun add(job: EventJobModel<T>) {
        if(queue.size >= MAX_QUEUE_SIZE){
            println("Queue Full!!!!")
            return
        }
        queue.add(job)
    }

    override fun execute() {
        worker.start()
    }

    override fun doFail(cb: (job: EventJobModel<T>) -> Unit) {
        this.failCb = cb
    }

    override fun isQueueFull(): Boolean  = queue.size >= MAX_QUEUE_SIZE

}