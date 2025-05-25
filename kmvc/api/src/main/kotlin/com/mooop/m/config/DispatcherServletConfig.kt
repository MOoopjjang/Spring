package com.mooop.m.config

import org.springframework.boot.ApplicationRunner
import org.springframework.web.servlet.DispatcherServlet

/**
 * PROJECT : kmvc
 * PACKAGE : com.mooop.m.config
 * FILE : DispatcherServletConfig.kt
 * create : 2025. 5. 25.
 * Make By : MOoop
 * DESC : Thread생성시 부모 thread의 속성을 승계
 *        - 부모 스레드의 bean factory에 접근이 가능하다.
 *-------------------------------------------------------
 * 1.0      MOoop            created
 *-------------------------------------------------------
 */
class DispatcherServletConfig  constructor(
    private val dispatcherServlet:DispatcherServlet
){
    fun setThreadContextInheritable() : ApplicationRunner{
        return ApplicationRunner{ args->
            dispatcherServlet.setThreadContextInheritable(true)
        }
    }
}