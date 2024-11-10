package com.mooop.m.domain.traffic.impl

import com.mooop.m.domain.traffic.TrafficLimitFilter
import com.mooop.m.domain.traffic.dto.TrafficMessage
import com.mooop.m.store.logic.AccessHistoryLogic
import org.springframework.stereotype.Component

/**
 * 사용자별 적용되는 filter
 */
@Component
class UserTrafficFilter constructor(
    val accessHistoryLogic: AccessHistoryLogic
): TrafficLimitFilter {
    override fun isAccessible(trafficMessage: TrafficMessage): Boolean {
        TODO("Not yet implemented")
    }
}