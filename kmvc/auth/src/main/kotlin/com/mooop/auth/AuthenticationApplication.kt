package com.mooop.auth

import com.mooop.core.auth.repository.AuthEntity
import com.mooop.core.auth.repository.AuthenticationRepository
import com.mooop.core.auth.vo.RoleType
import com.mooop.core.config.DatabaseConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
 * Project : kmvc
 * Package :com.mooop.auth
 * Author :  zinnaworks
 * Date : 29/04/2022
 * Desc :
 */
@Import(value = [DatabaseConfig::class])
@EntityScan(basePackages = ["com.mooop.core.auth.repository"])
@EnableJpaRepositories(basePackages = ["com.mooop.core.auth.repository"])
@SpringBootApplication
class AuthenticationApplication{
    @Autowired
    lateinit var repository:AuthenticationRepository

    @PostConstruct
    fun init(){
        val e1 = AuthEntity().apply {
            this.email = "cwkim@zinnaworks.com"
            this.password = "1111"
            this.roleType = RoleType.USER
            this.username = "cwkim"
        }
        repository.save(e1)

        val e2 = AuthEntity().apply {
            this.email = "bhkim@zinnaworks.com"
            this.password = "2222"
            this.roleType = RoleType.ADMIN
            this.username = "bhkim"
        }
        repository.save(e2)
    }
}



fun main(args:Array<String>){
    val application = SpringApplication(AuthenticationApplication::class.java)
    application.addInitializers(BeanDefinitions())
    application.run(*args)


}



