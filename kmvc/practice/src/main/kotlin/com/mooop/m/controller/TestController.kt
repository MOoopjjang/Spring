package com.mooop.m.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.m.controller
 * Author :  zinnaworks
 * Date : 25/04/2022
 * Desc :
 */
@Controller
@RequestMapping("/test")
class TestController {

    @GetMapping("/t1")
    fun t1(request:HttpServletRequest , response:HttpServletResponse):String = "t1"

}