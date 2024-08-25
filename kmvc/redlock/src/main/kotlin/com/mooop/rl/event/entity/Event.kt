package com.mooop.rl.event.entity

import javax.persistence.*

/**
 * Project: kmvc
 * Package :com.mooop.rl.event.entity
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */

@Entity
@Table(name = "TST_EVENT")
data class Event constructor(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EV_SEQ")
    var evSeq:Int?=null,

    @Column(name = "LIMIT_COUNT")
    var limitCount:Int?=null,

    @OneToMany(mappedBy = "event")
    var eventTickets:MutableList<EventTicket> = mutableListOf()
){
    fun isClosed():Boolean = limitCount!! <= eventTickets!!.size
}
