package com.mooop.m.ex4.controller

import com.mooop.m.ex4.repository.Ex4LockerRepository
import com.mooop.m.ex4.repository.Ex4MemberRepository
import com.mooop.m.ex4.repository.entity.Ex4Locker
import com.mooop.m.ex4.repository.entity.Ex4Member
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Project: kmvc
 * Package :com.mooop.m.ex4.controller
 * Author : mooopjjang
 * Date 2024/01/24
 * DESC : 1:1 관계 테스트
 */

@RestController
@RequestMapping("/ex4/test")
class Ex4TestController constructor(
    val ex4MemberRepository: Ex4MemberRepository
    ,val ex4LockerRepository: Ex4LockerRepository
){


    @GetMapping("/t1")
    fun t1():Ex4Member{

        val locker = Ex4Locker(name = "B4")
        ex4LockerRepository.save(locker)
        val member = Ex4Member(username = "cwkim")
        member.locker = locker
        val r = ex4MemberRepository.saveAndFlush(member)
        return r
    }
}