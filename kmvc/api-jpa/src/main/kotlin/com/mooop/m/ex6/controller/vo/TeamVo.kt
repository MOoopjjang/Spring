package com.mooop.m.ex6.controller.vo

class TeamVo {

    var id:Long?=null
    var teamName:String?=null
    var members:MutableList<MutableMap<String , Any>>?= mutableListOf()
}