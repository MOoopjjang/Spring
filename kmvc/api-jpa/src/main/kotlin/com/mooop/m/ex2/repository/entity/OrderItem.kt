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
@Table(name = "TST_ORDER_ITEM")
class OrderItem constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ORDER_ITEM_ID")
    var id:Long?=null,

    @Column(name = "ORDER_PRICE")
    var orderPrice:Long?=null,

    @Column(name = "COUNT")
    var count:Int?=null,

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    var order:Order?=null,

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    var item:Item?=null

){

    fun changeOrder(order:Order) : OrderItem{
        this.order?.orderItems?.remove(this)
        this.order = order
        this.order!!.orderItems.add(this)
        return this
    }



}