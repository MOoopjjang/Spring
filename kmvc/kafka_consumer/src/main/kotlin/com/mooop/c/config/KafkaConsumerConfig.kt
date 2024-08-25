package com.mooop.c.config

import com.mooop.c.model.Person
import com.mooop.c.model.PersonDeserializer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

/**
 * Project: kmvc
 * Package :com.mooop.c.config
 * Author : mooopjjang
 * Date 2023/01/06
 * DESC :
 */
@Configuration
class KafkaConsumerConfig {
    @Value("\${kafka.bootstrap-servers}")
    private lateinit var BSERVER:String

    @Value("\${kafka.consumer.text-group.gid}")
    private lateinit var T_GID:String

    @Value("\${kafka.consumer.data-group.gid}")
    private lateinit var D_GID:String

    @Bean
    fun textConsumerFactory():ConsumerFactory<String , String> =
        DefaultKafkaConsumerFactory(
            mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to BSERVER
            ,ConsumerConfig.GROUP_ID_CONFIG to T_GID
            ,ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
            ,ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
            ,ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest"
//            JsonDeserializer.TRUSTED_PACKAGES to "*"
        )
        )


    @Bean
    fun textKafkaListenerContainerFactory():ConcurrentKafkaListenerContainerFactory<String , String> =
        ConcurrentKafkaListenerContainerFactory<String , String>().apply {
            this.consumerFactory = textConsumerFactory()
        }


    @Bean
    fun dataConsumerFactroy():ConsumerFactory<String , Person>{
        return DefaultKafkaConsumerFactory(mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to BSERVER
            ,ConsumerConfig.GROUP_ID_CONFIG to D_GID
            ,ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
            ,ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to PersonDeserializer::class.java
            ,ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest"
        ))
    }


    @Bean
    fun dataKafkaListenerContainerFactory():ConcurrentKafkaListenerContainerFactory<String , Person> =
        ConcurrentKafkaListenerContainerFactory<String , Person>().apply {
            this.consumerFactory = dataConsumerFactroy()
        }

}