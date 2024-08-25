package com.mooop.m.team.controller

import com.mooop.m.team.controller.vo.TeamResVo
import com.mooop.m.team.controller.vo.TeamVo
import com.mooop.m.team.service.TeamService
import org.springframework.web.bind.annotation.*

/**
 * Project: kmvc
 * Package :com.mooop.m.controller
 * Author : mooopjjang
 * Date 2024/01/22
 * DESC :
 */

@RequestMapping("/ex1/team")
@RestController
class TeamController constructor(
    val teamService: TeamService
){

    @PostMapping("")
    fun registry(@RequestBody teamVo: TeamVo) : String =
        teamService.registryForTeamInfo(teamVo)

    @GetMapping("/info/{name}")
    fun info(@PathVariable name:String): TeamResVo = teamService.getTeamInfo(name)

}