package com.mooop.m.team.repository

import com.mooop.m.team.repository.entity.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Project: kmvc
 * Package :com.mooop.m.repository
 * Author : mooopjjang
 * Date 2024/01/18
 * DESC :
 */
@Repository
interface TeamRepository : JpaRepository<Team, String> {

    fun findByName(name:String): Team?
}