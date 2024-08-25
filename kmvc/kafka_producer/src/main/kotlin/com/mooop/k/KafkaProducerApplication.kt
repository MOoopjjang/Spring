package com.mooop.k

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Project: kmvc
 * Package :com.mooop.k
 * Author : mooopjjang
 * Date 2023/01/04
 * DESC : 카프카 PRODUCER SAMPLE
 */
@SpringBootApplication
class KafkaProducerApplication


fun main(args:Array<String>){
    runApplication<KafkaProducerApplication>(*args)
}