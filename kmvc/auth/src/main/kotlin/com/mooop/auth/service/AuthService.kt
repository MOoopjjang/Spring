package com.mooop.auth.service

import com.mooop.core.auth.repository.AuthenticationRepository
import com.mooop.core.jwt.JwtAuthenticationProvider
import com.mooop.core.jwt.vo.JwtVo
import com.mooop.core.jwt.vo.TokenUserVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Project : kmvc
 * Package :com.mooop.auth.service
 * Author :  zinnaworks
 * Date : 30/04/2022
 * Desc :
 */
@Service("authService")
class AuthService @Autowired constructor(
    private val jwtAuthenticationProvider: JwtAuthenticationProvider
    ,private val authenticationRepository: AuthenticationRepository){

    /**
     * JWT 생성
     */
    fun getJwt(param:TokenUserVo):JwtVo? =
        authenticationRepository.findByEmail(param.username!!)
            ?.let{
                val provider =  jwtAuthenticationProvider.getJwtDetailsService()
                provider.createToken(param)
            }?:null


    /**
     * Token의 유효성 체크
     */
    fun chk(token:String):Boolean = jwtAuthenticationProvider.getJwtDetailsService().validationToken(token)

}