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
@Table(name = "EX8_TST_MEMBER")
data class Ex8Member constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EX8_MID")
    var id:Long?=null,

    @Column(name = "NAME")
    var name:String?=null,

    @Column(name = "AGE")
    var age:Int?=null,

    @ManyToOne
    @JoinColumn(name = "EX8_TID")
    var team:Ex8Team?=null,

    @JoinColumn(name="EX8_FID")
    var family:Ex8Family?=null

){

    fun changeTeam(team:Ex8Team){
        this.team?.members?.remove(this)
        this.team = team
        this.team!!.members!!.add(this)
    }
}
