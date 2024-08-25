package com.mooop.k.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest

/**
 * Project: kmvc
 * Package :com.mooop.k.controller
 * Author : mooopjjang
 * Date 2023/01/04
 * DESC :
 */
@Controller
class KafkaProducerController {

    @GetMapping("/producer/m")
    fun main(request:HttpServletRequest):String = "main"

}