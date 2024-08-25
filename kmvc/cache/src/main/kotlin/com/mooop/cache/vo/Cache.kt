package com.mooop.cache.vo

import java.io.Serializable

/**
 * Project : kmvc
 * Package :com.mooop.cache.vo
 * Author :  zinnaworks
 * Date : 11/04/2022
 * Desc :
 */
data class Cache(
    var title:String? = null
    ,var content:String? = null
    ,var id:Long? = null
): Serializable
