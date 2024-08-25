package com.mooop.auth

import com.mooop.core.jwt.JwtAuthenticationProvider
import com.mooop.core.jwt.JwtDetailsService
import org.springframework.beans.factory.config.BeanDefinitionCustomizer
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import java.util.function.Supplier

/**
 * Project : kmvc
 * Package :com.mooop.auth
 * Author :  zinnaworks
 * Date : 30/04/2022
 * Desc :
 */
class BeanDefinitions : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(applicationContext: GenericApplicationContext) {
        applicationContext.registerBean(
            JwtDetailsService::class.java,
            Supplier { JwtDetailsService() },   //수동으로 주입하고자 하는 component
            BeanDefinitionCustomizer { beanDef->
                beanDef.isAutowireCandidate = true  //true로 설정해야 자동으로 bean주입된다.
            }
        )

        applicationContext.registerBean(
            JwtAuthenticationProvider::class.java,
            Supplier { JwtAuthenticationProvider() },   //수동으로 주입하고자 하는 component
            BeanDefinitionCustomizer { beanDef->
                beanDef.isAutowireCandidate = true  //true로 설정해야 자동으로 bean주입된다.
            }
        )

    }
}