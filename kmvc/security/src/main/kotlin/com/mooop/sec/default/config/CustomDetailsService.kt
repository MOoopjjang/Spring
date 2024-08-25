package com.mooop.sec.default.config

import com.mooop.sec.common.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Project : kmvc
 * Package :com.mooop.sec.default.config
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@Service
class CustomDetailsService constructor(val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepository.findByEmail(username!!)?.let{
            var builder = User.withUsername(it.email)
            builder.password(it.password)
                .authorities(it.roleType.code)
                .build()
        }?:throw UsernameNotFoundException("$username")
    }
}