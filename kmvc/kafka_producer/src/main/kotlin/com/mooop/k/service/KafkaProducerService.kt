package com.mooop.k.service

import com.mooop.k.model.Person
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.FailureCallback
import org.springframework.util.concurrent.SuccessCallback

/**
 * Project: kmvc
 * Package :com.mooop.k.service
 * Author : mooopjjang
 * Date 2023/01/04
 * DESC :
 */
@Service
class KafkaProducerService constructor(
    val simpleKafkaTemplate:KafkaTemplate<String , String>,
    val dataKafkaTemplate:KafkaTemplate<String , Person>
){

    val log = LoggerFactory.getLogger(KafkaProducerService::class.java)

    @Value("\${kafka.text-topic}")
    private lateinit var simpleTopic:String

    @Value("\${kafka.data-topic}")
    private lateinit var dataTopic:String

    @Value("\${kafka.bootstrap-servers}")
    private lateinit var BSERVER:String


    fun sendMessage(message:String){
        simpleKafkaTemplate.send(simpleTopic , message)
            .addCallback(
                SuccessCallback { result->
                    log.info("Sent Message: ${message} with offset:${result!!.recordMetadata.offset()}")
                }, FailureCallback { ex->
                    log.error("unable to send message:${message}-${ex}")
                }
            )
    }


    fun sendMessage(message:Person){
        dataKafkaTemplate.send(dataTopic , message)
            .addCallback(
                SuccessCallback { result->
                    log.info("Sent Message: ${message} with offset:${result!!.recordMetadata.offset()}")
                }, FailureCallback { ex->
                    log.error("unable to send message:${message}-${ex}")
                }
            )
    }


}