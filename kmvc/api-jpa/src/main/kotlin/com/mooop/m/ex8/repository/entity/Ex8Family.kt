package com.mooop.m.ex8.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.repository.entity
 * Author : mooopjjang
 * Date 2024/03/18
 * DESC :
 */

@Entity
@Table(name="EX8_TST_FAMILY")
data class Ex8Family constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EX8_FID")
    var id:Long?=null,

    @Column(name="FAMILY_COUNT")
    var familyCount:Int?=null,

//    @OneToOne(fetch = FetchType.LAZY)
//    var member:Ex8Member?=null

)
