package com.mooop.m.ex8.controller

import com.mooop.m.ex8.controller.vo.*
import com.mooop.m.ex8.repository.Ex8MemberRepository
import com.mooop.m.ex8.repository.Ex8MemberSpecification
import com.mooop.m.ex8.repository.Ex8TeamRepository
import com.mooop.m.ex8.repository.entity.Ex8Member
import com.mooop.m.ex8.repository.entity.Ex8Team
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.domain.Specification
import org.springframework.web.bind.annotation.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.controller
 * Author : mooopjjang
 * Date 2024/03/11
 * DESC :
 */

@RestController
@RequestMapping("/ex8")
class Ex8Controller constructor(
    val teamRepository: Ex8TeamRepository
    ,val memberRepository: Ex8MemberRepository
){

    val LOGGER = LoggerFactory.getLogger(Ex8Controller::class.java)


    @PostMapping("/team/regist")
    fun createTeam(@RequestBody team:Ex8TeamVo):String{
        LOGGER.info(">>> team = {}" , team.toString())
        return teamRepository.save(Ex8Team(
            teamName = team.teamName
        )).let {
            "Success"
        }
    }

    @PostMapping("/member/regist")
    fun createMember(@RequestBody memberReq: MemberRegistReqVo):String{
        LOGGER.info(">>> memberReq = {}" , memberReq.toString())


        return teamRepository.findByTeamName(memberReq.teamName!!)?.run {
//            LOGGER.info(">>> team = {}" , this.toString())

            val member = Ex8Member(name = memberReq.name , age = memberReq.age)
            member.changeTeam(this)
            memberRepository.save(member)
        }.let {
            "Success"
        }
    }


    @GetMapping("/team/info/{teamName}")
    fun teamInfo(@PathVariable teamName:String):TeamInfoResVo?{
        return teamRepository.findByTeamName(teamName)?.let { t->
            val ti = TeamInfoResVo(id = t.id , teamName = t.teamName)
            val l = t.members!!.map { m->
                Member(id = m.id , name = m.name , age = m.age)
            }
            ti.members = l!!
            ti
        }
    }


    @GetMapping("/member/infos/{name}")
    fun membersInfo(@PathVariable name:String):List<MemberInfoResVo>{

        // filter 1 :  이름 like 검색
        var spec:Specification<Ex8Member> = Specification.where(
            Ex8MemberSpecification.likeName(name)
        )

        // filter 2 : 1 and 나이 조건 검색
         spec = spec.and(Ex8MemberSpecification.betweenAge(30 , 45))



        return memberRepository.findAll(spec).map {
            MemberInfoResVo(id = it.id , name = it.name , age = it.age)
        }

    }
}