package com.mooop.m.infra.db.logic

import com.mooop.m.infra.filters.traffic.query.TrafficFilterQueryInterface
import com.mooop.m.infra.filters.traffic.dto.AccessHistoryDto
import com.mooop.m.infra.db.entity.AccessHistoryData
import com.mooop.m.infra.db.entity.toDomain
import com.mooop.m.infra.db.repository.AccessHistoryRepositoryImpl
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Component
class TrafficFilterLogic constructor(
    private val accessHistoryRepositoryImpl: AccessHistoryRepositoryImpl
) : TrafficFilterQueryInterface {

    val log = LoggerFactory.getLogger(TrafficFilterLogic::class.java)

    override fun registry(accessHistoryDto: AccessHistoryDto):Boolean{
        accessHistoryRepositoryImpl.save(AccessHistoryData(accessHistoryDto.userId , accessHistoryDto.url))
        return true
    }

    override fun count():Int = accessHistoryRepositoryImpl.countAll()
    override fun retrieveAll() :List<AccessHistoryDto> = accessHistoryRepositoryImpl.findAll().map { data->
        data.toDomain()
    }
    override fun retrieveByUserId(userId:String):List<AccessHistoryDto> = accessHistoryRepositoryImpl.findByUserId(userId).map { data->data.toDomain() }
    override fun retrieveByUserIdAndUrl(userId: String , url:String):List<AccessHistoryDto> = accessHistoryRepositoryImpl.findByUserIdAndUrl(userId,url).map { data->data.toDomain() }
}