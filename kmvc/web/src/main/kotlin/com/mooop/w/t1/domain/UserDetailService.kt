package com.mooop.w.t1.domain

import org.springframework.stereotype.Service
import org.springframework.web.context.annotation.SessionScope

/**
 * Session이 유효할동안 값이 유지된다.
 *  - Session이 만료될경우 호출될시점에 새로 생성이 되며 값은 당연히 초기화되어 있다.
 *  - 하나의 요청에 내부에 redirection기능이 포함되어 있을경우 값을 공유할수 있는 좋은 방법이다.
 */
@Service
@SessionScope
class UserDetailService {

    var login:Boolean = false
        get() = field
        set(value) {
            field = value
        }
    private var username:String?=null
    private var password:String?=null

    fun userDetailInfo(username:String , password:String) : Boolean{
        this.login = true
        this.username = username
        this.password = password

        return true
    }

//    fun isLogin():Boolean = this.login

    fun username():String = this.username?:""

    fun password():String = this.password?:""
}