package com.mooop.m.infra.db.entity

import com.mooop.m.infra.filters.traffic.dto.AccessHistoryDto
import java.time.LocalDateTime

data class AccessHistoryData constructor(
    val userId:String
    , val url:String
    , val createdAt:LocalDateTime = LocalDateTime.now()
)

/** DTO로 변환 */
fun AccessHistoryData.toDomain() = AccessHistoryDto(this.userId , this.url , this.createdAt)