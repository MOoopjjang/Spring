package com.mooop.m.team.controller.vo

/**
 * Project: kmvc
 * Package :com.mooop.m.controller.vo
 * Author : mooopjjang
 * Date 2024/01/22
 * DESC :
 */
data class TeamResVo constructor(
    var tid:String?=null,
    var name:String?=null,
    var members:List<Map<String , Any>>? = null
)