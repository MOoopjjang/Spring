package com.mooop.dispatcherservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class DispatchService

fun main(args:Array<String>){
    runApplication<DispatchService>(*args)
}