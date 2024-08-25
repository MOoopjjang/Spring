package com.mooop.m.ex6.repository.entity

import javax.persistence.*

@Entity
@Table(name = "TST_EX6_TEAM")
class Ex6Team constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TID")
    var id:Long?=null,

    @Column(name = "TEAM_NAME")
    var teamName:String?=null,

    @OneToMany(mappedBy = "team" , fetch = FetchType.LAZY)
    var members:MutableList<Ex6Member>? = mutableListOf()

) {
}