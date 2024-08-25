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
@Table(name = "TST_TEACHER")
class Teacher constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID")
    var id:Long?=null,

    @Column(name = "NAME")
    var name:String? = null,

    @Column(name = "AGE")
    var age:Int? = null,

    @Column(name = "SUBJECT")
    var subject:String?=null,

    /**
     * 단방향연결일 경우 @JoinColumn을 1 쪽에 선언
     */
    @OneToMany
    @JoinColumn(name="TEACHER_ID")
    var students:MutableList<Student> = mutableListOf()
) {
}