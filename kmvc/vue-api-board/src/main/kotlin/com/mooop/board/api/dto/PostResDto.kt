package com.mooop.board.api.dto

import java.time.LocalDateTime

data class PostResDto constructor(
    val id:Int,
    val title:String,
    val content:String,
    val createdAt:LocalDateTime,
    val user:User
)
