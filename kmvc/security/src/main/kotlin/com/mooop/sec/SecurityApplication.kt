package com.mooop.sec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

/**
 * Project : kmvc
 * Package :com.mooop.sec
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@EnableWebSecurity
@SpringBootApplication
class SecurityApplication


fun main(args:Array<String>){
    runApplication<SecurityApplication>(*args)
}