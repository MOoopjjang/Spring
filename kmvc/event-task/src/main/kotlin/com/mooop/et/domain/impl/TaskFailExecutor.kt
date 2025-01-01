package com.mooop.et.domain.impl

import com.mooop.et.domain.BasicTaskExecutor
import com.mooop.et.domain.model.EventJobModel

class TaskFailExecutor<T> : BasicTaskExecutor<T>() {
    override fun add(job: EventJobModel<T>) {
        TODO("Not yet implemented")
    }

    override fun execute() {
        TODO("Not yet implemented")
    }

    override fun isQueueFull(): Boolean {
        TODO("Not yet implemented")
    }

    override fun failThen(cb: (r: EventJobModel<T>) -> Unit) {
        TODO("Not yet implemented")
    }

}