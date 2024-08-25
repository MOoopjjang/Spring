package com.mooop.m.ex3.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex3.repository.entity
 * Author : mooopjjang
 * Date 2024/01/23
 * DESC :
 */

@Entity
@Table(name = "TST_STUDENT")
class Student constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    var id:Long?=null,

    @Column(name = "NAME")
    var name:String?=null,
    @Column(name = "AGE")
    var age:Int?=null,
    @Column(name = "LEVEL")
    var level:Int?=null,

){


}