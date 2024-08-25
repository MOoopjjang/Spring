package com.mooop.m.controller

import com.mooop.core.vo.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.api.controller
 * Author :  zinnaworks
 * Date : 08/04/2022
 * Desc :
 */
@RestController
@RequestMapping("/api")
class ApiController {
    val log = LoggerFactory.getLogger(ApiController::class.java)

    @GetMapping("/t1")
    fun t1(request:HttpServletRequest , response:HttpServletResponse):ApiResponse<Map<String , String>>{
        Thread.sleep(500L)
        return ApiResponse.ok(mutableMapOf<String , String>().apply {
            this["name"] = "xferlog"
            this["age"] = "20"
        })
    }


    @GetMapping("/t2")
    fun t2(request:HttpServletRequest) : ApiResponse<Map<String , String>>{
        log.info(">>>> called")
        Thread.sleep(2000)
        return ApiResponse.ok(mutableMapOf<String , String>().apply {
            this["name"] = "xferlog"
            this["age"] = "20"
        })
    }


    @PostMapping("/t3")
    fun t3(@RequestBody paramM:Map<String , String> , request: HttpServletRequest):ApiResponse<String>{
        log.info(">>> header = {}" , request.getHeader("x-access-token"))
        log.info(">>> body = {}" , paramM.toString())
        return ApiResponse.ok("SUCCESS")
    }



    @GetMapping("/t4")
    fun t4(getUserId:String):ApiResponse<MutableMap<String , String>>{
        log.info(">>>>>> ApiController --> t4() :{} Called!!!!!!!!",getUserId)
        return ApiResponse.ok(mutableMapOf<String , String>().apply {
            this["name"] = "xferlog"
            this["age"] = "20"
        })
    }
}