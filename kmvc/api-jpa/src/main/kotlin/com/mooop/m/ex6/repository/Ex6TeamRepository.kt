package com.mooop.m.ex6.repository

import com.mooop.m.ex6.repository.entity.Ex6Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface Ex6TeamRepository : JpaRepository<Ex6Team , Long> {

    fun findByTeamName(teamName:String):Ex6Team?

    @Query("select distinct t from Ex6Team t join fetch t.members where t.teamName=:teamName ")
    fun findByTeamInfo(@Param("teamName") teamName:String):List<Ex6Team>?
}