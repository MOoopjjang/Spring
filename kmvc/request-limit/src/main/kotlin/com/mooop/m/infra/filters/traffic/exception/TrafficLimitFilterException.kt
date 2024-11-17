package com.mooop.m.infra.filters.traffic.exception

import com.mooop.m.infra.filters.traffic.exception.code.TrafficLimitExceptionCode

class TrafficLimitFilterException(message: String?) : RuntimeException(message) {
    lateinit var errorCode: TrafficLimitExceptionCode

    constructor(errorCode: TrafficLimitExceptionCode):this(errorCode.desc){
        this.errorCode = errorCode
    }
}