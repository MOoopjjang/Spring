package com.mooop.core.vo

/**
 * Project : kmvc
 * Package :com.mooop.core.vo
 * Author :  zinnaworks
 * Date : 08/04/2022
 * Desc :
 */
data class ApiResponse<T>(
    var result:String?="",
    var reason:String?="",
    var data:T?=null
){

    companion object{
        /**
         *
         */
        fun<T> ok(data:T?):ApiResponse<T> = ApiResponse(RET_OK , null , data)


        /**
         *
         */
        fun<T> error(reason:String?):ApiResponse<T> = ApiResponse(RET_FAILED , reason , null)
    }
}

const val RET_OK:String = "OK"
const val RET_FAILED:String = "FAILED"