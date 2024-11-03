package com.mooop.m

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan


@SpringBootApplication
@ServletComponentScan
class RequestLimitApplication

fun main(args:Array<String>){
    runApplication<RequestLimitApplication>(*args)
}