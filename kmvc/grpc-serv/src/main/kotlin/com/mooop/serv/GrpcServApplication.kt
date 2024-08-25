package com.mooop.serv

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class GrpcServApplication


fun main(args:Array<String>){
    runApplication<GrpcServApplication>(*args)
}