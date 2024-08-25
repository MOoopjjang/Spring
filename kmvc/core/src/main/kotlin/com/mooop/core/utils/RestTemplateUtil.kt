package com.mooop.core.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

/**
 * Project : kmvc
 * Package :com.mooop.core.utils
 * Author :  zinnaworks
 * Date : 18/04/2022
 * Desc :
 */
@Component("restTemplateUtil")
class RestTemplateUtil /*@Autowired constructor(private val restTemplate:RestTemplate)*/{

    @Autowired
    lateinit var restTemplate:RestTemplate
    /**
     *  GET
     */
    fun<T> get(url:String , cls:Class<T> ,headerKeys:Array<String>? , headerValues:Array<String>?):T{
        /**
         * Header값을 셋팅한다.
         */
        val headers:HttpHeaders = HttpHeaders()
        headerKeys?.run {
            for(index in this.indices){
                headers[this[index]] = headerValues!!.get(index)
            }
        }

        val getRequest:HttpEntity<HttpHeaders> = HttpEntity(headers)
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
            getRequest,
            cls
        ).body!!
    }


    /**
     *  POST
     */
    fun<T,R> post(url:String , resCls:Class<R> , param:T ,headerKeys:Array<String>? , headerValues:Array<String>?):R{
        val headers:HttpHeaders = HttpHeaders()
        headerKeys?.run {
            for(index in this.indices){
                headers[this[index]] = headerValues!!.get(index)
            }
        }

        val postRequest:HttpEntity<T> = HttpEntity(param , headers)
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            postRequest,
            resCls
        ).body!!
    }
}