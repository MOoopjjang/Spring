package com.mooop.sec.default.config

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.savedrequest.HttpSessionRequestCache
import org.springframework.security.web.savedrequest.RequestCache
import org.springframework.security.web.savedrequest.SavedRequest
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.sec.default.config
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
class LoginSuccessHandler : AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        val requestCache:RequestCache = HttpSessionRequestCache()
        val rUrl:String = requestCache.getRequest(request , response)?.let {
            val u = it.redirectUrl
            requestCache.removeRequest(request , response)
            u
        }?:request!!.contextPath.plus("/main/m")


        response!!.sendRedirect(rUrl)
    }
}