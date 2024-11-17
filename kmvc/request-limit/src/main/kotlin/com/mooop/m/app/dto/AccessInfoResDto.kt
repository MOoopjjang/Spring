package com.mooop.m.app.dto

import java.time.LocalDateTime

data class AccessInfoResDto constructor(
    val userId:String,
    val url:String,
    val accessTime:LocalDateTime
)