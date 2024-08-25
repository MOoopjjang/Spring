package com.mooop.mcmrc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class McmrcApplication


fun main(args:Array<String>){
    runApplication<McmrcApplication>(*args)
}