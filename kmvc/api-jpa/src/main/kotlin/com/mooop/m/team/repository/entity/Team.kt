package com.mooop.m.team.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.repository.entity
 * Author : mooopjjang
 * Date 2024/01/18
 * DESC :
 */

@Table
@Entity(name = "TST_TEAM")
class Team constructor(

    @Id @Column(name = "TEAM_TID")
    var tid:String? = null,

    @Column(name = "NAME")
    var name:String? = null,

    @OneToMany(mappedBy = "team" , fetch = FetchType.EAGER)
    var members:MutableList<Member> = mutableListOf()

)