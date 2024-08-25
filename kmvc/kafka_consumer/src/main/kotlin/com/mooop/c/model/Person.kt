package com.mooop.c.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Project: kmvc
 * Package :com.mooop.c.model
 * Author : mooopjjang
 * Date 2023/01/10
 * DESC :
 */
data class Person(
    @JsonProperty("name")
    val name:String?=null,
    @JsonProperty("age")
    val age:Int?=0,
    @JsonProperty("zipCode")
    val zipCode:String?=null,
    @JsonProperty("address")
    val address:String?=null
)
