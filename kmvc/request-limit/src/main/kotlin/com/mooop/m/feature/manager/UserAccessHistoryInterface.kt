package com.mooop.m.feature.manager

import com.mooop.m.feature.manager.dto.CheckOverAccessLimit
import com.mooop.m.feature.manager.model.UserAccessInfo


/**
 * 1. 역할
 *   - 사용자접속 기록에 대한 모든 정보를 제공한다.
 * 2. 행동
 *   - 사용자 접속정보를 등록하는 기능제공
 *
 *   - 사용자에 대한 접속정보 제공
 *     ㄴ 접속 유무
 *     ㄴ 시간 구간사이에 접속 유무
 *     ㄴ 시간 구간사이에 접속 Count
 *     ㄴ 최대 접속 허용 초과 유무
 *
 *
 */
interface UserAccessHistoryInterface {

    /** 사용자 접속정보를 등록한다. */
    fun registry(accessInfo: UserAccessInfo) : Boolean

    /** User 접속정보를 반환한다 */
    fun retrieveUser(userId:String) : List<UserAccessInfo>?

    /** 유저 접속 유무 */
    fun existUserAccessHistory(user:String):Boolean

    /**
     * 시간구간안에 ( sectionTime ~ 지금 ) 접속요청한 사용자가 최대접속혀용 횟수 초과유무 반환
     */
    fun checkOverAccessLimit(  checkOverAccessLimit: CheckOverAccessLimit):Boolean

}