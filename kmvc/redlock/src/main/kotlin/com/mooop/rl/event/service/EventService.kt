package com.mooop.rl.event.service

import com.mooop.rl.common.system.RedisLockRepository
import com.mooop.rl.event.controller.vo.TicketVo
import com.mooop.rl.event.entity.EventTicket
import com.mooop.rl.event.repository.EventRepository
import com.mooop.rl.event.repository.EventTicketRepository
import org.redisson.api.RLock
import org.redisson.api.RedissonClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

/**
 * Project: kmvc
 * Package :com.mooop.rl.event.service
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */
@Service
class EventService constructor(
    val eventRepository: EventRepository,
    val eventTicketRepository: EventTicketRepository,
    val redisLockRepository: RedisLockRepository,
    val redissonClient: RedissonClient
) {

    val LOCK_KEY = "event_key"
    val log = LoggerFactory.getLogger(EventService::class.java)

    fun applyForTicket(ticket:TicketVo) : TicketApplyResDto{
        /** spin lock */
        while(!redisLockRepository.lock(LOCK_KEY)!!){
            log.info(">> delay >> ticket = {}" , ticket.toString())
            Thread.sleep(100)
        }
        val evt =  eventRepository.findByEvSeq(1)
//        log.info(">>>>1 > evt  = {}" , evt.toString())
        if(evt.isClosed()){
            throw Exception("이벤트가 종료되었습니다.")
        }

        val ticketEntity = EventTicket().apply {
            this.ticketName = ticket.ticketName
            this.event = evt
        }
        eventTicketRepository.save(ticketEntity)
        evt.eventTickets.add(ticketEntity)

        /** spin lock to unlock */
        redisLockRepository.unlock(LOCK_KEY)

        return TicketApplyResDto("0000" , evt.isClosed() , evt.limitCount!! , evt.eventTickets!!.size)
    }


    fun applyForTicket2(ticket:TicketVo) : TicketApplyResDto{
        val lock: RLock = redissonClient.getLock(LOCK_KEY)
        while(!lock.tryLock(10 , 10 , TimeUnit.MINUTES)){
            Thread.sleep(10)
        }

        val evt =  eventRepository.findByEvSeq(1)
//        log.info(">>>>1 > evt  = {}" , evt.toString())
        if(evt.isClosed()){
            throw Exception("이벤트가 종료되었습니다.")
        }

        val ticketEntity = EventTicket().apply {
            this.ticketName = ticket.ticketName
            this.event = evt
        }
        eventTicketRepository.save(ticketEntity)
        evt.eventTickets.add(ticketEntity)

        if(lock.isLocked && lock.isHeldByCurrentThread){
            lock.unlock()
        }

        return TicketApplyResDto("0000" , evt.isClosed() , evt.limitCount!! , evt.eventTickets!!.size)
    }
}