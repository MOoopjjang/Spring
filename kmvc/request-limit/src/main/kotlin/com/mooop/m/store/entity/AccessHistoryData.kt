package com.mooop.m.store.entity

import com.mooop.m.store.dto.AccessHistoryDto
import java.time.LocalDateTime

data class AccessHistoryData constructor(
    val userId:String
    , val url:String
    , val createdAt:LocalDateTime = LocalDateTime.now()
)

/** DTO로 변환 */
fun AccessHistoryData.toDomain() = AccessHistoryDto(this.userId , this.url , this.createdAt)