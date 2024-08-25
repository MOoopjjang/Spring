package com.mooop.k.config

import com.mooop.k.model.Person
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

/**
 * Project: kmvc
 * Package :com.mooop.k.config
 * Author : mooopjjang
 * Date 2023/01/16
 * DESC :
 */
@Configuration
class KafkaProducerConfig {
    @Value("\${kafka.bootstrap-servers}")
    lateinit var BSERVER:String


    @Bean
    fun simpleProducerFactory():ProducerFactory<String , String> =
        DefaultKafkaProducerFactory<String , String>(mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BSERVER,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        ))


    @Bean
    fun simpleKafkaTemplate():KafkaTemplate<String , String> = KafkaTemplate<String , String>(simpleProducerFactory())



    @Bean
    fun dataProducerFactory():ProducerFactory<String , Person> =
        DefaultKafkaProducerFactory<String , Person>(mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BSERVER,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
        ))


    @Bean
    fun dataKafkaTemplate():KafkaTemplate<String , Person> = KafkaTemplate<String , Person>(dataProducerFactory())
}