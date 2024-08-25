package com.mooop.rd1.controller.model

/**
 * Project: kmvc
 * Package :com.mooop.rd1.controller.model
 * Author : mooopjjang
 * Date 2023/09/29
 * DESC :
 */
data class StudentVo constructor(
    val name:String
    ,val age:Int
    ,var addr:String?=""
    ,var score:Int? = 0
)
