package com.mooop.m.facade

import com.mooop.m.feature.RequestLimitAction
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/request-limit")
class RequestLimitResource constructor(
    val requestLimitAction: RequestLimitAction
){

    @GetMapping("/dl")
    fun proceedDL(request:HttpServletRequest):ResponseEntity<String> = ResponseEntity.ok().body("SUCCESS")


}