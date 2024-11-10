package com.mooop.m.store.dto

import java.time.LocalDateTime

data class AccessHistoryDto constructor(
    val userId:String
    , val url:String
    , var createdAt: LocalDateTime
)
