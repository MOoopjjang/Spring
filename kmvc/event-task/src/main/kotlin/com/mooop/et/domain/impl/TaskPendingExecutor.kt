package com.mooop.et.domain.impl

import com.mooop.et.domain.BasicTaskExecutor
import com.mooop.et.domain.TaskFailInterface
import com.mooop.et.domain.TaskTransferInterface
import com.mooop.et.domain.enums.EventActionType
import com.mooop.et.domain.model.EventJobModel

class TaskPendingExecutor<T> : BasicTaskExecutor<T>()
    , TaskTransferInterface<T>
    , TaskFailInterface<T> {
    lateinit var tranfCb:(job:EventJobModel<T>)->Unit?
    lateinit var failCb:(job:EventJobModel<T>)->Unit?

    val pendingWorker = {
        while(!isStop){
            val task = queue.take()
            try{
                println("TaskPendingExecutor -> actionType = ${task.actionType}")
                if(task.actionType == EventActionType.UNKNOWN){
                    failCb(task)
                }else{
                    tranfCb(task)
                }
            }catch (ex:Exception){
                failCb(task)
            }
        }
    }
    val worker:Thread = Thread(pendingWorker)

    override fun add(job: EventJobModel<T>) {
        queue.add(job)
    }

    override fun execute() {
        worker.start()
    }

    override fun isQueueFull(): Boolean  = false


    override fun doTransfer(cb: (job: EventJobModel<T>) -> Unit) {
        this.tranfCb = cb
    }

    override fun doFail(cb: (job: EventJobModel<T>) -> Unit) {
        this.failCb = cb
    }


}
