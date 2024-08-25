package com.mooop.sec.common.dto

/**
 * Project : kmvc
 * Package :com.mooop.sec.common.dto
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
class User constructor(
    var email:String,
    var username:String,
    var password:String? = null,
    var roleType:String? = null
)