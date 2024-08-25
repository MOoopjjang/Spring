package com.mooop.core.jwt.vo

/**
 * Project : kmvc
 * Package :com.mooop.core.jwt.vo
 * Author :  zinnaworks
 * Date : 15/04/2022
 * Desc :
 */
data class TokenUserVo(
    var username:String?="",
    var password:String?="",
    var roles:Array<String>?=null
){

    companion object{
        fun create(username:String , password:String , roles:Array<String>):TokenUserVo =
            TokenUserVo(username , password , roles)
    }

}
