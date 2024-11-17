package com.mooop.m.infra.filters.traffic

import com.mooop.m.infra.filters.traffic.dto.TrafficMessage

interface TrafficLimitFilter {
    fun getPriority():Int
    fun isAccessible( trafficMessage : TrafficMessage) : Boolean
}