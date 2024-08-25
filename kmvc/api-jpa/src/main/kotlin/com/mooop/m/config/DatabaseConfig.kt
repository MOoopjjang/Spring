package com.mooop.m.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Project: kmvc
 * Package :com.mooop.m.config
 * Author : mooopjjang
 * Date 2024/01/17
 * DESC :
 */

@Configuration
class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    fun hikariConfig() = HikariConfig()

    @Bean
    fun dataSource() = HikariDataSource(hikariConfig())

}