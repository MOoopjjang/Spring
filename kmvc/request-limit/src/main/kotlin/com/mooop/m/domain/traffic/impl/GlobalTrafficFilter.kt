package com.mooop.m.domain.traffic.impl

import com.mooop.m.domain.traffic.TrafficLimitFilter
import com.mooop.m.domain.traffic.dto.TrafficMessage
import com.mooop.m.store.logic.AccessHistoryLogic
import org.springframework.stereotype.Component

/**
 * 서비스 전체에 적용되는 필터
 */
@Component
class GlobalTrafficFilter constructor(
    val accessHistoryLogic: AccessHistoryLogic
) : TrafficLimitFilter {
    override fun isAccessible(trafficMessage: TrafficMessage): Boolean {
        TODO("Not yet implemented")
    }
}