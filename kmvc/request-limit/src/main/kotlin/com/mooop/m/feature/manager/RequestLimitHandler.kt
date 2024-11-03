package com.mooop.m.feature.manager

import com.mooop.m.feature.manager.model.UserLimitInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class RequestLimitHandler {

    @Value("\${app.limit-time-section}")
    lateinit var limitTimeSection:Integer

//    @Value("\${app.limit-urls}")
//    lateinit var limitUrls:List<String>

    val mapper:MutableMap<String , UserLimitInfo>  = mutableMapOf()







//    fun  isAllowAccess(tokenId:String ,  ) : Boolean{
//
//    }

}