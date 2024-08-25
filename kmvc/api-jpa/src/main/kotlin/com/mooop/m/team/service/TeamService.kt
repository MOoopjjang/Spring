package com.mooop.m.team.service

import com.mooop.m.team.controller.vo.TeamResVo
import com.mooop.m.team.controller.vo.TeamVo
import com.mooop.m.team.domain.TeamDomain
import com.mooop.m.team.factory.TeamFactory
import com.mooop.m.team.repository.TeamRepository
import org.springframework.stereotype.Service

/**
 * Project: kmvc
 * Package :com.mooop.m.service
 * Author : mooopjjang
 * Date 2024/01/22
 * DESC :
 */

@Service
class TeamService constructor(
    val teamRepository: TeamRepository
    ,val teamDomain: TeamDomain
){

    // TODO : 기존 team정보가 존재한다면. 기존 정보반환 code 추가필요...
    fun registryForTeamInfo(teamVo: TeamVo) : String =
        TeamFactory.createTeamEntity(teamVo).let {
            teamRepository.save(it)
            "SUCCESS"
        }


    fun getTeamInfo(name:String) : TeamResVo = teamDomain.getTeamInfo(name)

}