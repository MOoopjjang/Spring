package com.mooop.m.ex8.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.repository.entity
 * Author : mooopjjang
 * Date 2024/03/11
 * DESC :
 */

@Entity
@Table(name = "EX8_TST_TEAM")
data class Ex8Team constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EX8_TID")
    var id:Long?=null,

    @Column(name = "TEAM_NAME")
    var teamName:String?=null,

    @OneToMany(mappedBy = "" , fetch = FetchType.LAZY)
    var members:MutableList<Ex8Member>? = mutableListOf()


)
