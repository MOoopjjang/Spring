package com.mooop.core.jwt

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Project : kmvc
 * Package :com.mooop.core.jwt
 * Author :  zinnaworks
 * Date : 18/04/2022
 * Desc :
 */
@Component("jwtAuthenticationProvider")
class JwtAuthenticationProvider{

    @Autowired
    private lateinit var jwtDetailsService:JwtDetailsService
    /**
     * JWT 관련기능을 제공하는 Service객체를 반환한다.
     */
    fun getJwtDetailsService():JwtDetailsService = jwtDetailsService
}