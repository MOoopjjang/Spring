package com.mooop.w.t1.domain

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope


@Component
@RequestScope
class LoginProcessor constructor(
    val userDetailService: UserDetailService
){

    private var username:String? = null
    private var password:String? = null


    fun login(username:String , password:String):Boolean {
        this.username = username
        this.password = password

        return userDetailService.userDetailInfo(this.username!! , this.password!!)
    }

}