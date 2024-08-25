package com.mooop.m.trace

import com.mooop.core.vo.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

/**
 * Project : kmvc
 * Package :com.mooop.m.trace
 * Author :  mooop
 * Date : 15/05/2022
 * Desc :
 */
@Profile(value = ["trace"])
@RestController
@RequestMapping("/trace")
class TraceController @Autowired constructor(val traceService: TraceService){

    @GetMapping("/t1")
    fun conT1(request:HttpServletRequest):ApiResponse<Map<String , String>> =
        ApiResponse.ok(traceService.serviceT1())


    @GetMapping("/error")
    fun conError(request:HttpServletRequest):ApiResponse<Map<String , String>> =
        ApiResponse.ok(traceService.serviceError())
}