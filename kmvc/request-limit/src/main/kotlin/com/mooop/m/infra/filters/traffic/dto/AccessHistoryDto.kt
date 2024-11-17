package com.mooop.m.infra.filters.traffic.dto

import java.time.LocalDateTime

data class AccessHistoryDto constructor(
    val userId:String
    , val url:String
    , var createdAt: LocalDateTime
)
