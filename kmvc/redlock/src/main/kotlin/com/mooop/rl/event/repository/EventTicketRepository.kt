package com.mooop.rl.event.repository

import com.mooop.rl.event.entity.EventTicket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Project: kmvc
 * Package :com.mooop.rl.event.repository
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */
@Repository
interface EventTicketRepository : JpaRepository<EventTicket , Int> {
}