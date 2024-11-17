package com.mooop.m.infra.filters.traffic.exception.code

enum class TrafficLimitExceptionCode constructor(
    val desc:String
){

    TRAFFIC_GLOBAL_EXCEPTION("서비스에 접근 초과하였습니다.")
    ,TRAFFIC_USER_EXCEPTION("user 접근횟수를 초과하였습니다.")


}