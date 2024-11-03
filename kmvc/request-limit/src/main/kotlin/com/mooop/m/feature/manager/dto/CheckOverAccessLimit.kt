package com.mooop.m.feature.manager.dto

data class CheckOverAccessLimit constructor(
    val userId:String
    ,val accessingUrl:String
    ,val checkOverAccessLimit:Int
    ,val  limitCount:Int
)