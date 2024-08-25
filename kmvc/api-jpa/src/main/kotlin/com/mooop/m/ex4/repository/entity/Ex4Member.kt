package com.mooop.m.ex4.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex4.repository.entity
 * Author : mooopjjang
 * Date 2024/01/24
 * DESC : 주테이블 ( FK 관리 )
 */
@Entity
@Table(name = "TST_EX4_MEMBER")
class Ex4Member constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBER_ID")
    var id:Long?=null,

    @Column(name = "NAME")
    var username:String?=null,

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    var locker:Ex4Locker?=null
){
}