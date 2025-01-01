package com.mooop.et

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class EventTaskApplication


fun main(args:Array<String>){
    runApplication<EventTaskApplication>(*args)
}