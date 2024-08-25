package com.mooop.m.team.service

import com.mooop.m.team.controller.vo.MemberVo
import com.mooop.m.team.domain.TeamDomain
import com.mooop.m.team.factory.MemberFactory
import com.mooop.m.team.repository.MemberRepository
import org.springframework.stereotype.Service
import java.lang.Exception

/**
 * Project: kmvc
 * Package :com.mooop.m.service
 * Author : mooopjjang
 * Date 2024/01/18
 * DESC :
 */

@Service
class MemberService constructor(
    val memberRepository: MemberRepository
    ,val teamDomain: TeamDomain
){


    /**
     * 신규멤버를 추가한다.
     */
    fun registry(member: MemberVo) : String =
        teamDomain.getTeam(member.teamName)?.let { t->
            MemberFactory.convertMemberEntity(member)
                .changeTeam(t)
                .let { nMember->
                    memberRepository.save(nMember)
                    "SUCCESS"
                }
        }?:throw Exception("${member.teamName} 에 맞는 team 이 존재하지 않습니다.")



}