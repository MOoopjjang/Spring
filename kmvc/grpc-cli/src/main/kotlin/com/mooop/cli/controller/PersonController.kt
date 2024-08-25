package com.mooop.cli.controller

import com.mooop.cli.dto.Person
import com.mooop.cli.service.GrpcPersonService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/cli/person")
class PersonController constructor(
    val grpcPersonService: GrpcPersonService
){
    val LOGGER = LoggerFactory.getLogger(PersonController::class.java)

    @GetMapping("/info/{userId}")
    fun personInfo(@PathVariable userId:String):Person{
        LOGGER.info(">>>> personInfo() -> userId = {}" , userId)
        return grpcPersonService.info(userId)
    }




}