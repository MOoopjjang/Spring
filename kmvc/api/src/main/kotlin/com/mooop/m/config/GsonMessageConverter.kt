package com.mooop.m.config

import com.google.gson.Gson
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.GsonHttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * PROJECT : kmvc
 * PACKAGE : com.mooop.m.config
 * FILE : GsonMessageConverter.kt
 * create : 2025. 5. 24.
 * Make By : MOoop
 * DESC : GSON message converter
 *-------------------------------------------------------
 * 1.0      MOoop            created
 *-------------------------------------------------------
 */

@Configuration
//@EnableWebMvc
class GsonMessageConverter : WebMvcConfigurer {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(this.gsonHttpMessageConverter())
        println("#################")
        super.configureMessageConverters(converters)
    }

    @Bean
    fun gsonHttpMessageConverter() : GsonHttpMessageConverter  =
        GsonHttpMessageConverter().apply {
            gson = Gson()
        }

}