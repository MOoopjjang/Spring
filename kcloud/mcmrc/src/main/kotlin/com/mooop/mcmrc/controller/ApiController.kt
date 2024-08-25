package com.mooop.mcmrc.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/mcmrc/api")
class ApiController {
    @Value("\${mcmrc.data}")
    lateinit var msg:String

    @GetMapping("/t1")
    fun t1():String = msg
}