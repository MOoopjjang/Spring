package com.mooop.m.domain.traffic

import com.mooop.m.domain.traffic.dto.TrafficMessage
import javax.servlet.http.HttpServletRequest

interface TrafficLimitFilter {
    fun isAccessible( trafficMessage : TrafficMessage) : Boolean
}