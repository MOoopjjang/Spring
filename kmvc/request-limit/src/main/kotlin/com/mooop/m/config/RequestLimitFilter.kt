package com.mooop.m.config

import com.mooop.m.infra.filters.traffic.TrafficLimitFilterChain
import com.mooop.m.infra.filters.traffic.exception.TrafficLimitFilterException
import com.mooop.m.infra.filters.traffic.query.TrafficFilterQueryInterface
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


//@Component
@WebFilter(urlPatterns = ["/access/user"])
class RequestLimitFilter constructor(
    val trafficLimitFilterChain: TrafficLimitFilterChain
//    ,val trafficFilterQueryInterface: TrafficFilterQueryInterface
): OncePerRequestFilter() {

    val log = LoggerFactory.getLogger(RequestLimitFilter::class.java)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try{
            trafficLimitFilterChain.exec(request)
        }catch (fe: TrafficLimitFilterException){
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
        }catch (e : Exception){
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
        }


        filterChain.doFilter(request,response)
    }


}