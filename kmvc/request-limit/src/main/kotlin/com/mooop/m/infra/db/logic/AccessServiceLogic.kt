package com.mooop.m.infra.db.logic

import com.mooop.m.app.query.AccessInfoServiceQueryInterface
import com.mooop.m.infra.db.entity.AccessHistoryData
import com.mooop.m.infra.db.repository.AccessHistoryRepositoryImpl
import org.springframework.stereotype.Component

@Component
class AccessServiceLogic constructor(
    val accessHistoryRepositoryImpl: AccessHistoryRepositoryImpl
) : AccessInfoServiceQueryInterface {
    override fun getUserAccessInformation(userId: String): List<AccessHistoryData> = accessHistoryRepositoryImpl.findByUserId(userId)
}