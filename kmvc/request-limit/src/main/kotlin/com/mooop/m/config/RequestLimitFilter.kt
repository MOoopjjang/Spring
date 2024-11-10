package com.mooop.m.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


//@Component
@WebFilter(urlPatterns = ["/request-limit/dl"])
class RequestLimitFilter : OncePerRequestFilter() {

//    val logger = LoggerFactory.getLogger(RequestLimitFilter::class.java)

    @Value("\${app.limit-count}")
    lateinit var timeSection:Integer

    @Value("\${app.limit-time-section}")
    lateinit var limitCount:Integer

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        println(">> timeSection = ${timeSection} , limitCount = ${limitCount} <<" )


        filterChain.doFilter(request,response)
    }


}