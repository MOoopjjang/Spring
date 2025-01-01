package com.mooop.et.domain

import com.mooop.et.domain.model.EventJobModel

interface TaskTransferInterface<T> {

    fun doTransfer(cb:(job:EventJobModel<T>)->Unit)
}