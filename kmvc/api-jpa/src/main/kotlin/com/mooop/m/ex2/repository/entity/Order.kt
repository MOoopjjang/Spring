package com.mooop.m.ex2.repository.entity

import com.mooop.m.ex2.code.OrderStatus
import java.time.LocalDateTime
import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.m.ex2.repository.entity
 * Author : mooopjjang
 * Date 2024/01/23
 * DESC :
 */
@Entity
@Table(name = "TST_ORDER")
class Order constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    var id:Long?=null,

    @Column(name="ORDER_DATE")
    var orderDate:LocalDateTime?=null,

    @Column(name = "STATUS")
    var status: OrderStatus?=null,

    @ManyToOne
    @JoinColumn(name = "OID")
    var member:OMember?=null,

    @OneToMany(mappedBy = "order" , fetch = FetchType.LAZY)
    var orderItems:MutableList<OrderItem> = mutableListOf()

){

    fun changeMember(member:OMember) : Order{
        this.member?.orders?.remove(this)
        this.member = member
        this.member!!.orders.add(this)
        return this
    }

    fun addOrderItem(orderItem:OrderItem){
        orderItems.add(orderItem)
        orderItem.order = this
    }
}