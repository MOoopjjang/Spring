package com.mooop.m.ex6.repository.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "TST_EX6_MEMBER")
class Ex6Member constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MID")
    var id:Long?=null,

    @Column(name = "NAME")
    var name:String?=null,

    @Column(name = "AGE")
    var age:Int?=null,

    @ManyToOne
    @JoinColumn(name = "TID")
    var team:Ex6Team?=null
) {

    fun changeTeam(team:Ex6Team){
        this.team?.members?.remove(this)
        this.team = team
        this.team?.members?.add(this)
    }
}