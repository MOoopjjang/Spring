package com.mooop.c

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Project: kmvc
 * Package :com.mooop.c
 * Author : mooopjjang
 * Date 2023/01/05
 * DESC : 카프카 CONSUMER SAMPLE
 */
@SpringBootApplication
class KafkaConsumerApplication

fun main(args:Array<String>){
    runApplication<KafkaConsumerApplication>(*args)
}