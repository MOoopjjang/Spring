package com.mooop.w

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScans


@SpringBootApplication
class WebApplication


fun main(args:Array<String>){
    runApplication<WebApplication>(*args)
}