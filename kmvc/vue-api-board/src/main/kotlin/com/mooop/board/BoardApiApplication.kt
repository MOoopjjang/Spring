package com.mooop.board

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BoardApiApplication


fun main(args:Array<String>){
    runApplication<BoardApiApplication>(*args)
}