package com.mooop.m.ex8.repository

import com.mooop.m.ex8.controller.vo.TeamInfoResVo
import com.mooop.m.ex8.repository.entity.Ex8Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.repository.entity
 * Author : mooopjjang
 * Date 2024/03/11
 * DESC :
 */
interface Ex8TeamRepository : JpaRepository<Ex8Team, Long> {
    fun findByTeamName(teamName:String):Ex8Team?
}