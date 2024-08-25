package com.mooop.m.swagger.vo

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

/**
 * Project: kmvc
 * Package :com.mooop.m.swagger.vo
 * Author : mooopjjang
 * Date 2023/02/19
 * DESC :
 */
data class STestVO(
    @field:NotBlank
    @field:Schema(name = "name" , description = "이름" , required = true)
    val name:String,

    @field:Min(10)
    @field:Schema(name = "age" , description = "나이" , required = true)
    val age:Int,

    @field:Schema(name = "address" , description = "주소" , required = false)
    val address:String
)
