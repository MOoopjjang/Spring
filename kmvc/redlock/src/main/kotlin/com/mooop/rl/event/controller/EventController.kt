package com.mooop.rl.event.controller

import com.mooop.rl.event.controller.vo.TicketVo
import com.mooop.rl.event.service.EventService
import com.mooop.rl.event.service.TicketApplyResDto
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Project: kmvc
 * Package :com.mooop.rl.event.controller
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */

@RestController
@RequestMapping("/event")
class EventController constructor(
    val eventService: EventService
) {
    val log = LoggerFactory.getLogger(EventController::class.java)

    @PostMapping("/ticket/apply")
    fun applyForTicket(@RequestBody ticket:TicketVo):TicketApplyResDto{
        log.info(">>> ticket = {}" , ticket.toString())
        return eventService.applyForTicket(ticket)
    }
}