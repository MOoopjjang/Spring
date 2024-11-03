package com.mooop.m.feature.manager.model

import java.time.LocalDateTime

/**
 * UserAccessHistory 에서 관리한 기록 Model
 */
data class UserAccessInfo constructor(
    val userId:String
    ,val userAccessUrl:String
    ,val accessTime:LocalDateTime
)
