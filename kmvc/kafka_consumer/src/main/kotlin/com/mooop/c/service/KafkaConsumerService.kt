package com.mooop.c.service

import com.mooop.c.model.Person
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

/**
 * Project: kmvc
 * Package :com.mooop.c.service
 * Author : mooopjjang
 * Date 2023/01/05
 * DESC :
 */
@Service
class KafkaConsumerService {
    val log = LoggerFactory.getLogger(KafkaConsumerService::class.java)

    @KafkaListener(topics = ["\${kafka.consumer.text-group.topic}"]
        , groupId = "\${kafka.consumer.text-group.gid}"
        , containerFactory = "textKafkaListenerContainerFactory")
    fun textTopicConsumer(message:String){
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        log.info("> receive message = {}" , message)
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
    }

    @KafkaListener(topics = ["\${kafka.consumer.data-group.topic}"]
        , groupId = "\${kafka.consumer.data-group.gid}"
        , containerFactory = "dataKafkaListenerContainerFactory")
    fun dataTopicConsumer(message: Person){
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        log.info("> receive Person = {}" , message)
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
    }
}