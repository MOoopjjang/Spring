package com.mooop.m.store.logic

import com.mooop.m.store.dto.AccessHistoryDto
import com.mooop.m.store.entity.AccessHistoryData
import com.mooop.m.store.entity.toDomain
import com.mooop.m.store.repository.AccessHistoryRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Component
class AccessHistoryLogic constructor(
    val accessHistoryRepository: AccessHistoryRepository
){

    val log = LoggerFactory.getLogger(AccessHistoryLogic::class.java)

    fun registry( accessHistoryDto: AccessHistoryDto ):Boolean{
        accessHistoryRepository.save(AccessHistoryData(accessHistoryDto.userId , accessHistoryDto.url))
        return true
    }

    fun count():Int = accessHistoryRepository.countAll()
    fun retrieveAll() :List<AccessHistoryDto> = accessHistoryRepository.findAll().map { data->
        data.toDomain()
    }
    fun retrieveByUserId(userId:String):List<AccessHistoryDto> = accessHistoryRepository.findByUserId(userId).map { data->data.toDomain() }
    fun retrieveByUserIdAndUrl(userId: String , url:String) = accessHistoryRepository.findByUserIdAndUrl(userId,url).map { data->data.toDomain() }
}