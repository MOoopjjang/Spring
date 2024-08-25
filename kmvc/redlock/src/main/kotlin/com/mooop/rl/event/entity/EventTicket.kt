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
@Table(name = "TST_EVENT_TICKET")
data class EventTicket constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ET_SEQ")
    var etSeq:Int?=null,

    @Column(name="TICKET_NAME")
    var ticketName:String?=null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EV_SEQ")
    var event:Event?=null
)
