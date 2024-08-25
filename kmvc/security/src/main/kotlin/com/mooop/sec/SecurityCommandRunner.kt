package com.mooop.sec

import com.mooop.sec.common.repository.UserEntity
import com.mooop.sec.common.repository.UserRepository
import com.mooop.sec.common.vo.RoleType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * Project: kmvc
 * Package :com.mooop.sec
 * Author : mooopjjang
 * Date 2023/01/04
 * DESC :
 */
@Component
class SecurityCommandRunner constructor(
    val userRepository: UserRepository
) : CommandLineRunner {
    val log: Logger = LoggerFactory.getLogger(SecurityCommandRunner::class.java)

    override fun run(vararg args: String?) {
        log.info(">>> SecurityCommandRunner -> Start")

        userRepository.findByEmail("cwkim@zinnaworks.com")?:
            userRepository.save(UserEntity().apply {
                this.username = "김철우"
                this.email = "cwkim@zinnaworks.com"
                this.password = "1111"
                this.roleType = RoleType.USER
            })

        userRepository.findByEmail("ejkim@zinnaworks.com")?:
            userRepository.save(UserEntity().apply {
                this.username = "김은중"
                this.email = "ejkim@zinnaworks.com"
                this.password = "2222"
                this.roleType = RoleType.ADMIN
            })

        log.info(">>> SecurityCommandRunner -> End")
    }
}