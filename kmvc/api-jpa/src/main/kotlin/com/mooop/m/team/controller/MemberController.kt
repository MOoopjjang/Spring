package com.mooop.m.team.controller

import com.mooop.m.team.controller.vo.MemberVo
import com.mooop.m.team.service.MemberService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Project: kmvc
 * Package :com.mooop.m.controller.vo
 * Author : mooopjjang
 * Date 2024/01/18
 * DESC :
 */

@RestController
@RequestMapping("/ex1/member")
class MemberController constructor(
    val memberService: MemberService
){

    val log: Logger = LoggerFactory.getLogger(MemberController::class.java)

    @PostMapping("")
    fun registry(@RequestBody member: MemberVo) : String = memberService.registry(member)

}