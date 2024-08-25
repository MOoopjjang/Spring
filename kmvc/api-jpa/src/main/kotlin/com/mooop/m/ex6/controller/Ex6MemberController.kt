package com.mooop.m.ex6.controller

import com.mooop.m.ex6.repository.Ex6MemberRepository
import com.mooop.m.ex6.repository.Ex6TeamRepository
import com.mooop.m.ex6.repository.entity.Ex6Member
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/ex6/member")
class Ex6MemberController constructor(
    val memberRepository: Ex6MemberRepository
    ,val teamRepository: Ex6TeamRepository
){
    val LOGGER = LoggerFactory.getLogger(Ex6MemberController::class.java)


    @GetMapping("/dummy/registry/{teamName}")
    fun registry(@PathVariable teamName:String):String =
         teamRepository.findByTeamName(teamName)?.let{ teamEntity->


            var m1 = Ex6Member(name = "cwkim" , age = 45)
            m1.changeTeam(teamEntity)
            memberRepository.save(m1)
            m1 = Ex6Member(name = "bhkim" , age = 50)
            m1.changeTeam(teamEntity)
            memberRepository.save(m1)

            "SUCCESS"
        }?:"EMPTY"


}