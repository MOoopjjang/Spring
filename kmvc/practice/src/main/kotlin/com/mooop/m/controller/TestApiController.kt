package com.mooop.m.controller

import com.mooop.core.utils.RestTemplateUtil
import com.mooop.core.vo.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.m.controller
 * Author :  zinnaworks
 * Date : 25/04/2022
 * Desc :
 */
@RestController
@RequestMapping("/api/test")
class TestApiController  @Autowired constructor(val restTemplateUtil: RestTemplateUtil){

    @GetMapping("/t1")
    fun t1(requst:HttpServletRequest  , response:HttpServletResponse):ApiResponse<*> =
        restTemplateUtil.get("http://localhost:9080/api/t1"
            , ApiResponse::class.java
            , null
            , null)
}