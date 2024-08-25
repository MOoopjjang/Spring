package com.mooop.sec.default.controller

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
@RequestMapping("/main")
class MainController {

    @GetMapping("/m")
    fun main(request: HttpServletRequest, response: HttpServletResponse):String = "def/main"
}