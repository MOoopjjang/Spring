package com.mooop.m.domain.traffic.impl

import com.mooop.m.domain.traffic.TrafficLimitFilter
import com.mooop.m.domain.traffic.dto.TrafficMessage

/**
 * 서비스 전체에 적용되는 필터
 */
class GlobalTrafficFilter : TrafficLimitFilter {
    override fun isAccessible(trafficMessage: TrafficMessage): Boolean {
        TODO("Not yet implemented")
    }
}