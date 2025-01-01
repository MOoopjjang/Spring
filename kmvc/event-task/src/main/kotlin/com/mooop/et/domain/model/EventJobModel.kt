package com.mooop.et.domain.model

import com.mooop.et.domain.enums.EventActionType

data class EventJobModel<T> constructor(
    var priority:Int? = null,
    val actionType: EventActionType,
    val body:T
)