package com.mooop.m.app.impl

import com.mooop.m.app.RequestLimitService
import com.mooop.m.app.dto.AccessInfoResDto
import com.mooop.m.app.query.AccessInfoServiceQueryInterface
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class RequestLimitServiceImpl constructor(
    val accessInfoServiceQueryInterface: AccessInfoServiceQueryInterface
): RequestLimitService {

    val log = LoggerFactory.getLogger(RequestLimitService::class.java)

    override fun getUserAccessInformation(userId:String): List<AccessInfoResDto> {
        log.info(">>> userId : {}" , userId)
        return accessInfoServiceQueryInterface.getUserAccessInformation(userId)
            ?.map { ua->AccessInfoResDto(ua.userId , ua.url , ua.createdAt) }
            ?: listOf()
    }


}