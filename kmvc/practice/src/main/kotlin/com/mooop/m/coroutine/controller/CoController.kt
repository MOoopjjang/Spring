package com.mooop.m.coroutine.controller

import com.mooop.core.vo.ApiResponse
import com.mooop.m.coroutine.service.CoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

/**
 * Project: kmvc
 * Package :com.mooop.m.coroutine.controller
 * Author : mooopjjang
 * Date 2023/02/26
 * DESC :
 */
@RestController
@RequestMapping("/co")
class CoController constructor(
    val coService: CoService
){


    @GetMapping("/t1")
    fun t1(request:HttpServletRequest) : ApiResponse<String>{

        println(">>>>> CoController --> t1 start")

        println(">>>>> CoController --> t1 end")
        return ApiResponse.ok("SUCCESS")
    }
}