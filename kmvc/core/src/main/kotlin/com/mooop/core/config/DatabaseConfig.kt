package com.mooop.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Project : kmvc
 * Package :com.mooop.core.config
 * Author :  zinnaworks
 * Date : 28/04/2022
 * Desc :
 */
@Configuration
class DatabaseConfig {

    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Bean
    fun hikariConfig():HikariConfig = HikariConfig()

    @Bean
    fun dataSource():DataSource = HikariDataSource(hikariConfig())
}