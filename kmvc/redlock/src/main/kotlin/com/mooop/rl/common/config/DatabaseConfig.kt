package com.mooop.rl.common.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Project: kmvc
 * Package :com.mooop.rl.common.config
 * Author : mooopjjang
 * Date 2023/12/06
 * DESC :
 */
@Configuration
class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    fun hikariConfig():HikariConfig = HikariConfig()

    @Bean
    fun dataSource():DataSource = HikariDataSource(hikariConfig())
}