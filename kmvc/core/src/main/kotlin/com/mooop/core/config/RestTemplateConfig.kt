package com.mooop.core.config

import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import javax.print.attribute.IntegerSyntax

/**
 * Project : kmvc
 * Package :com.mooop.core.config
 * Author :  zinnaworks
 * Date : 18/04/2022
 * Desc :
 */
@Configuration
class RestTemplateConfig {

    @Value("\${network.time.connection}")
    lateinit var CONNECTION_TIMEOUT:Integer
    @Value("\${network.time.read}")
    lateinit var READ_TIMEOUT:Integer
    @Value("\${network.rt.max-conn}")
    lateinit var RT_MAX_CONN:Integer
    @Value("\${network.rt.max-per-route}")
    lateinit var RT_MAX_PER_ROUTE:Integer


    @Bean
    fun restTemplate():RestTemplate{
        val httpClient:HttpClient = HttpClientBuilder.create()
            .setMaxConnPerRoute(RT_MAX_PER_ROUTE.toInt())
            .setMaxConnTotal(RT_MAX_CONN.toInt())
            .build()

        val factory:HttpComponentsClientHttpRequestFactory = HttpComponentsClientHttpRequestFactory().apply {
            this.setConnectTimeout(CONNECTION_TIMEOUT.toInt())
            this.setReadTimeout(READ_TIMEOUT.toInt())
            this.httpClient = httpClient
        }
        return RestTemplate(BufferingClientHttpRequestFactory(factory))
    }
}