package com.mooop.k.controller

import com.mooop.k.model.Person
import com.mooop.k.service.KafkaProducerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

/**
 * Project: kmvc
 * Package :com.mooop.k.controller
 * Author : mooopjjang
 * Date 2023/01/04
 * DESC :
 */
@RestController
@RequestMapping("/api/producer")
class KafkaProducerApiController constructor(
    val service:KafkaProducerService
){

    @PostMapping("/send/simple")
    fun send(@RequestBody param:Map<String , Any>, request:HttpServletRequest):ResponseEntity<String> =
        service.sendMessage(param["message"] as String)
            .run {
                ResponseEntity.ok("OK")
            }

    @PostMapping("/send/data")
    fun send(@RequestBody param: Person, request: HttpServletRequest):ResponseEntity<String> =
        service.sendMessage(param).run {
            ResponseEntity.ok("OK")
        }

}