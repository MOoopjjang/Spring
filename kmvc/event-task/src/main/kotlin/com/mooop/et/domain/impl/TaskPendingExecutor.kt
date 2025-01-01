package com.mooop.et.domain.impl

import com.mooop.et.domain.BasicTaskExecutor
import com.mooop.et.domain.TaskTransferInterface
import com.mooop.et.domain.model.EventJobModel

class TaskPendingExecutor<T> : BasicTaskExecutor<T>(), TaskTransferInterface<T> {
    lateinit var tranfCb:(job:EventJobModel<T>)->Unit?

    override fun add(job: EventJobModel<T>) {
        TODO("Not yet implemented")
    }

    override fun execute() {
        TODO("Not yet implemented")
    }

    override fun isQueueFull(): Boolean {
        TODO("Not yet implemented")
    }


    override fun doTransfer(cb: (job: EventJobModel<T>) -> Unit) {
        this.tranfCb = cb
    }


}