package com.mooop.m.ex5.repository.entity

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
abstract class Ex5Item constructor(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ITEM_ID")
        var id:Long?=null,

        @Column(name = "NAME")
        var name:String?=null,

        @Column(name = "PRICE")
        var price:Long?=null
)