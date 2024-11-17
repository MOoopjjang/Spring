package com.mooop.m.infra.filters.traffic.query

import com.mooop.m.infra.filters.traffic.dto.AccessHistoryDto


interface TrafficFilterQueryInterface {
    fun registry( accessHistoryDto: AccessHistoryDto):Boolean
    fun count():Int
    fun retrieveAll() :List<AccessHistoryDto>
    fun retrieveByUserId(userId:String):List<AccessHistoryDto>
    fun retrieveByUserIdAndUrl(userId: String , url:String):List<AccessHistoryDto>
}