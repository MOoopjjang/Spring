package com.mooop.sec.default.config

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component

/**
 * Project : kmvc
 * Package :com.mooop.sec.default.config
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@Component("customAuthenticationProvider")
class CustomAuthenticationProvider constructor( val customDetailsService: CustomDetailsService) : AuthenticationProvider{
    override fun authenticate(authentication: Authentication?): Authentication {
        var token = (authentication as UsernamePasswordAuthenticationToken)
        var username:String = token.principal as String
        var password:String = token.credentials as String
        println("username : $username - password : $password")
        return customDetailsService.loadUserByUsername(username)
            ?.let {ud->
                if(ud.password != password){
                    throw BadCredentialsException(username)
                }
                var gl = ud.authorities as Collection<GrantedAuthority>
                println("gl = ${gl}")
                UsernamePasswordAuthenticationToken(ud.username , ud.password , gl)
            }
    }

    override fun supports(authentication: Class<*>?): Boolean =
        UsernamePasswordAuthenticationToken::class.java == authentication
}