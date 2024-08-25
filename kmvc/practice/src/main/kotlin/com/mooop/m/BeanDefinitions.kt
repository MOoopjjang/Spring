package com.mooop.m

import com.mooop.core.trace.LogTraceService
import com.mooop.core.upload.FileUploadProvider
import com.mooop.core.upload.vo.UploadProperties
import com.mooop.core.utils.RestTemplateUtil
import org.springframework.beans.factory.config.BeanDefinitionCustomizer
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import java.util.function.Supplier

/**
 * Project : kmvc
 * Package :com.mooop.m
 * Author :  zinnaworks
 * Date : 25/04/2022
 * Desc :
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

        applicationContext.registerBean(
            UploadProperties::class.java,
            Supplier { UploadProperties() },
            BeanDefinitionCustomizer { beanDef->
                beanDef.isAutowireCandidate = true
            }
        )

        applicationContext.registerBean(
            FileUploadProvider::class.java,
            Supplier { FileUploadProvider() },
            BeanDefinitionCustomizer { beanDef->
                beanDef.isAutowireCandidate = true
            }
        )


        applicationContext.registerBean(
            LogTraceService::class.java,
            Supplier { LogTraceService() },
            BeanDefinitionCustomizer { beanDef->
                beanDef.isAutowireCandidate = true
            }
        )


    }
}