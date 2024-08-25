package com.mooop.cache.controller

import com.mooop.cache.service.CacheService
import com.mooop.cache.vo.Cache
import com.mooop.core.vo.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.cache.controller
 * Author :  zinnaworks
 * Date : 11/04/2022
 * Desc :
 */
@RestController
@RequestMapping("/cache/api")
class CacheApiController {

    @Autowired
    lateinit var cacheService:CacheService

    @GetMapping("/t1")
    fun t1(request:HttpServletRequest , response:HttpServletResponse): ApiResponse<Cache> =
        ApiResponse.ok(cacheService.t1())

    @GetMapping("/t2")
    fun t2(request:HttpServletRequest , response:HttpServletResponse): ApiResponse<Map<String , Any>> =
        ApiResponse.ok(cacheService.t2((request.getParameter("id") as String).toLong()))


    @GetMapping("/t3")
    fun t3(request:HttpServletRequest , response:HttpServletResponse): ApiResponse<Cache> =
        ApiResponse.ok(cacheService.t3((request.getParameter("id") as String).toLong()))
}