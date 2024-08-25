package com.mooop.m.team.domain

import com.mooop.m.team.controller.vo.TeamResVo
import com.mooop.m.team.repository.TeamRepository
import com.mooop.m.team.repository.entity.Team
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Project: kmvc
 * Package :com.mooop.m.domain
 * Author : mooopjjang
 * Date 2024/01/22
 * DESC :
 */

@Component
class TeamDomain constructor(
    private val teamRepository: TeamRepository
){

    private val log = LoggerFactory.getLogger(TeamDomain::class.java)


    /**
     * team이름에 매칭되는 team정보 반환
     */
    fun getTeamInfo(teamName:String) : TeamResVo =
        teamRepository.findByName(teamName)?.let { team->
            TeamResVo(
                team.tid!!
            ,team.name!!
            ,team.members?.let { list->
                list.map { member->
                    mutableMapOf<String , Any>("name" to member.name as Any , "age" to member.age as Any)
                }
                }?: listOf()
            )
        }?: TeamResVo(null,null,null)



    fun getTeam(teamName:String) : Team? = teamRepository.findByName(teamName)


}