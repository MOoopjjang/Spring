package com.mooop.es

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ExamServApplication


fun main(args:Array<String>){
    runApplication<ExamServApplication>(*args)
}