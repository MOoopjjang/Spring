package com.mooop.sec.default.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.sec.default.controller
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@Controller
@RequestMapping("/auth")
class AuthController {
    @GetMapping("/login")
    fun login(request:HttpServletRequest , response:HttpServletResponse):String = "def/login"


    @GetMapping("/logout")
    fun logout(request: HttpServletRequest , response: HttpServletResponse)=
        SecurityContextHolder.getContext().authentication?.let {
            SecurityContextLogoutHandler().logout(request , response , it)
            "redirect:/auth/login"
        }?:"redirect:/auth/login"

}