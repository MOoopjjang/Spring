package com.mooop.m.team.factory

import com.mooop.m.team.controller.vo.TeamVo
import com.mooop.m.team.repository.entity.Team
import java.util.*

/**
 * Project: kmvc
 * Package :com.mooop.m.factory
 * Author : mooopjjang
 * Date 2024/01/22
 * DESC :
 */
class TeamFactory {

    companion object{
        fun createTeamEntity(teamVo: TeamVo) : Team =
            Team(tid = UUID.randomUUID().toString().replace("-" , "")
                , name = teamVo.name)
    }
}