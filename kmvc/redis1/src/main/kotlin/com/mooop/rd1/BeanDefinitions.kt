package com.mooop.rd1

import com.mooop.core.utils.RestTemplateUtil
import org.springframework.beans.factory.config.BeanDefinitionCustomizer
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import java.util.function.Supplier

/**
 * Project: kmvc
 * Package :com.mooop.rd1
 * Author : mooopjjang
 * Date 2023/09/29
 * DESC :
 */
class BeanDefinitions : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(applicationContext: GenericApplicationContext) {
        applicationContext.registerBean(
            RestTemplateUtil::class.java,
            Supplier { RestTemplateUtil() },
            BeanDefinitionCustomizer { beanDef->
                beanDef.isAutowireCandidate = true
            }
        )
    }
}