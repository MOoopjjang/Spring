package com.mooop.sec.common.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Project : kmvc
 * Package :com.mooop.sec.common.config
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@Configuration
class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    fun hikariConfig():HikariConfig = HikariConfig()

    @Bean
    fun dataSource():DataSource = HikariDataSource(hikariConfig())
}