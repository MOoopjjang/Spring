package com.mooop.m.ex6.controller

import com.mooop.m.ex6.controller.vo.TeamVo
import com.mooop.m.ex6.repository.Ex6TeamRepository
import com.mooop.m.ex6.repository.entity.Ex6Team
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct


@RequestMapping("/ex6/team")
@RestController
class Ex6TeamController constructor(
    val teamRepository: Ex6TeamRepository
) {

    val LOGGER = LoggerFactory.getLogger(Ex6TeamController::class.java)

    @PostConstruct
    fun initData(){
        LOGGER.info(">>> initData()!!!")
        val team = Ex6Team(
            teamName = "T1"
        )
        teamRepository.saveAndFlush(team)
    }


    @GetMapping("/infos/{teamName}")
    fun infos(@PathVariable teamName:String):List<TeamVo>{
        return teamRepository.findByTeamInfo(teamName)?.let {
            it.map {et->
                TeamVo().apply {
                    this.id = et.id
                    this.teamName = et.teamName
                    et.members?.map { em->
                        this.members?.add(mutableMapOf("name" to em.name!! , "age" to em.age!! ))
                    }
                }
            }
        }?: mutableListOf()
    }


}