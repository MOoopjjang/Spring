package com.mooop.m.team.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.repository.entity
 * Author : mooopjjang
 * Date 2024/01/18
 * DESC :
 */

@Entity(name = "TST_MEMBER")
class Member constructor(

    @Id @Column(name = "MEMBER_MID")
    var mid:String? = null,

    @Column(name = "NAME")
    var name:String? = null,

    @Column(name = "AGE")
    var age:Int? = null,

    @ManyToOne
    @JoinColumn(name = "TEAM_TID")
    var team: Team? =null
){
    fun changeTeam(team: Team) : Member {
        this.team?.members?.remove(this)

        this.team = team
        this.team!!.members.add(this)
        return this
    }
}
