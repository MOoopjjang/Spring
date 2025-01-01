package com.mooop.et.domain

import com.mooop.et.domain.model.EventJobModel

interface TaskFailInterface<T> {

    fun doFail(cb:(job:EventJobModel<T>)->Unit)
}