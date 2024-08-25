package com.mooop.rl.event.repository

import com.mooop.rl.event.entity.Event
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
interface EventRepository : JpaRepository<Event, Int> {
//    fun findById(id:Int):Event

    fun findByEvSeq(seq:Int):Event
}