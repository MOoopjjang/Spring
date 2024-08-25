package com.mooop.m.ex2.repository.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex2.repository.entity
 * Author : mooopjjang
 * Date 2024/01/23
 * DESC :
 */
@Entity
@Table(name = "TST_ORDER_ITEM_INFO")
class Item constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    var id:Long?=null,

    @Column(name="NAME")
    var name:String?=null,

    @Column(name="PRICE")
    var price:Long?=null,

    @Column(name="QUANTITY")
    var stockQuantity:Int?=null,

){
}