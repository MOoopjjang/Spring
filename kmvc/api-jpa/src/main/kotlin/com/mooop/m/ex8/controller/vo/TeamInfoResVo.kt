package com.mooop.m.ex8.controller.vo

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.controller.vo
 * Author : mooopjjang
 * Date 2024/03/11
 * DESC :
 */
data class TeamInfoResVo constructor(
    var id:Long?=null,
    var teamName:String?=null,
    var members:List<Member>? = mutableListOf()
)
