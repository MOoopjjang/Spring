package com.mooop.m.ex4.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex4.repository.entity
 * Author : mooopjjang
 * Date 2024/01/24
 * DESC :
 */
@Entity
@Table(name = "TST_EX4_LOCKER")
class Ex4Locker constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCKER_ID")
    var id:Long?=null,

    @Column(name = "NAME")
    var name:String?=null,

) {
}