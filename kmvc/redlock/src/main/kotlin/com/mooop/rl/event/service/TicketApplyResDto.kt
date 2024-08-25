package com.mooop.rl.event.service

/**
 * Project: kmvc
 * Package :com.mooop.rl.event.service
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */
data class TicketApplyResDto constructor(
    val code:String,
    val isClose:Boolean,
    val limitCount:Int,
    val currentCount:Int
)
