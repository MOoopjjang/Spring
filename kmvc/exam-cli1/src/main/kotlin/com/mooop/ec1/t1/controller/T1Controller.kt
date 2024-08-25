package com.mooop.ec1.t1.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest


@Controller
class T1Controller {

    @GetMapping("/ex1/landing")
    fun ex1(request:HttpServletRequest):String{
        return "ex1"
    }

    @GetMapping("/t1/complete")
    fun completePage():String{
        return "complete"
    }
}