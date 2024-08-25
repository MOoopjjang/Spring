package com.mooop.c.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin

/**
 * Project: kmvc
 * Package :com.mooop.c.config
 * Author : mooopjjang
 * Date 2023/01/06
 * DESC :
 */
//@Configuration
class TopicConfig {

//    @Value("\${kafka.bootstrap-servers}")
//    private lateinit var BSERVER:String
//
//    @Value("\${kafka.consumer.text-group.topic}")
//    private lateinit var T_TOPIC:String
//
//    @Value("\${kafka.consumer.data-group.topic}")
//    private lateinit var D_TOPIC:String
//
//
//    @Bean
//    fun textTopic():NewTopic =
//        TopicBuilder.name(T_TOPIC)
//            .partitions(1)
//            .replicas(1)
//            .build()
//
//    @Bean
//    fun dataTopic():NewTopic =
//        TopicBuilder.name(D_TOPIC)
//            .partitions(1)
//            .replicas(1)
//            .build()
//
//
//    @Bean
//    fun kafkaAdmin():KafkaAdmin =
//        KafkaAdmin(mapOf(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to BSERVER))
}