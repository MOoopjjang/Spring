package com.mooop.rd1

import com.mooop.core.config.DatabaseConfig
import com.mooop.core.config.RestTemplateConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

/**
 * Project: kmvc
 * Package :com.mooop.rd1
 * Author : mooopjjang
 * Date 2023/05/29
 * DESC :
 */
@Import(value = [RestTemplateConfig::class  , DatabaseConfig::class])
@SpringBootApplication
class Redis1Application

fun main(args:Array<String>){
    val application: SpringApplication = SpringApplication(Redis1Application::class.java)
    application.addInitializers(BeanDefinitions())
    application.run(*args)
}