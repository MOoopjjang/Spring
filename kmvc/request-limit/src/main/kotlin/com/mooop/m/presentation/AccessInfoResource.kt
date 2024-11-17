package com.mooop.m.presentation

import com.mooop.m.app.RequestLimitService
import com.mooop.m.app.dto.AccessInfoResDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/access")
class AccessInfoResource constructor(
    val requestLimitService: RequestLimitService
){

    @GetMapping("/user")
    fun userAccessInformation(request:HttpServletRequest) : List<AccessInfoResDto> =
        request.getHeader("userId").let { userId->
            requestLimitService.getUserAccessInformation(userId)
        }

}