package com.mooop.sec.default.config

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.sec.default.config
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
class LoginFailureHandler : AuthenticationFailureHandler {
    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        response!!.sendRedirect(request!!.contextPath.plus("/auth/login?error=Y"))
    }
}