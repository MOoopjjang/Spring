package com.mooop.w.t1

import com.mooop.w.t1.domain.LoginProcessor
import com.mooop.w.t1.model.UserInfo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class T1LoginController constructor(
    val loginProcessor: LoginProcessor
){


    val LOGGER = LoggerFactory.getLogger(T1LoginController::class.java)

    @GetMapping("/t1/login")
    fun login() : String = "t1/login"

    @PostMapping("/t1/login")
    fun proceedLogin(userInfo: UserInfo) : String {
        LOGGER.info(">>> userInfo = {}" , userInfo.toString())
        loginProcessor.login(userInfo.username!! , userInfo.password!!)
        return "redirect:/t1/main"
    }
}