package com.mooop.m.ex2.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex2.repository.entity
 * Author : mooopjjang
 * Date 2024/01/23
 * DESC :
 */
@Table(name = "TST_O_MEMBER")
@Entity
data class OMember constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID")
    var id:Long?=null,

    var name:String?=null,
    var city:String?=null,
    var zipcode:String?=null,

    @OneToMany(mappedBy = "member" , fetch =  FetchType.LAZY)
    var orders:MutableList<Order> = mutableListOf()

)
