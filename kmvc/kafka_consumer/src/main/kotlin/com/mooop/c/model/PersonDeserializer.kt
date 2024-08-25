package com.mooop.c.model

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets.UTF_8

/**
 * Project: kmvc
 * Package :com.mooop.c.model
 * Author : mooopjjang
 * Date 2023/01/18
 * DESC :
 */
class PersonDeserializer : Deserializer<Person> {
    private val om:ObjectMapper = ObjectMapper()
    private val log = LoggerFactory.getLogger(PersonDeserializer::class.java)
    override fun deserialize(topic: String?, data: ByteArray?): Person {
        log.info(">> PersonDeserializer deserialize....")
        return om.readValue(
            String(data?:throw SerializationException("Error when deserializing byte[] to Product") , UTF_8)
        ,Person::class.java)
    }
}