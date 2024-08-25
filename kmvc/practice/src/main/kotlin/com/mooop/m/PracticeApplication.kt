package com.mooop.m

import com.mooop.core.config.AwsS3Config
import com.mooop.core.config.DatabaseConfig
import com.mooop.core.config.RestTemplateConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * Project : kmvc
 * Package :com.mooop.m
 * Author :  zinnaworks
 * Date : 24/04/2022
 * Desc :
 */
@Import(value = [RestTemplateConfig::class , AwsS3Config::class , DatabaseConfig::class])
@EntityScan(basePackages = ["com.mooop.core.upload.repository" , "com.mooop.m.t2.repository"])
@EnableJpaRepositories(basePackages = ["com.mooop.core.upload.repository" , "com.mooop.m.t2.repository"])
@SpringBootApplication
class PracticeApplication

fun main(args:Array<String>){
    val application:SpringApplication = SpringApplication(PracticeApplication::class.java)
    application.addInitializers(BeanDefinitions())
    application.run(*args)
}

