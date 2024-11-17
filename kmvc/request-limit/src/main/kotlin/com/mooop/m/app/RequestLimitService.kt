package com.mooop.m.app

import com.mooop.m.app.dto.AccessInfoResDto

interface RequestLimitService {

    /**
     * 사용자 접근이력 정보제공
     */
    fun getUserAccessInformation(userId:String):List<AccessInfoResDto>
}