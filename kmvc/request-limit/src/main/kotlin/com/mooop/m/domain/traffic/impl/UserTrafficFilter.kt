package com.mooop.m.domain.traffic.impl

import com.mooop.m.domain.traffic.TrafficLimitFilter
import com.mooop.m.domain.traffic.dto.TrafficMessage

/**
 * 사용자별 적용되는 filter
 */
class UserTrafficFilter : TrafficLimitFilter {
    override fun isAccessible(trafficMessage: TrafficMessage): Boolean {
        TODO("Not yet implemented")
    }
}