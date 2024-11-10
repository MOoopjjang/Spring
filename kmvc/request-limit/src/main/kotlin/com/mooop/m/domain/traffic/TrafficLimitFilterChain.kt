package com.mooop.m.domain.traffic

import com.mooop.m.domain.traffic.dto.TrafficMessage
import com.mooop.m.domain.traffic.impl.GlobalTrafficFilter
import com.mooop.m.domain.traffic.impl.UserTrafficFilter
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest


@Component
class TrafficLimitFilterChain constructor(
    val globalTrafficFilter: GlobalTrafficFilter
    ,val userTrafficFilter: UserTrafficFilter
){

    val log = LoggerFactory.getLogger(TrafficLimitFilterChain::class.java)
    /**  */
    private val limiterFilters:MutableList<TrafficLimitFilter> by lazy { mutableListOf() }


    @PostConstruct
    fun initialize(){
        limiterFilters.add(globalTrafficFilter)
        limiterFilters.add(userTrafficFilter)
    }

    fun register(@Autowired filter:TrafficLimitFilter){
        limiterFilters.add(filter)
    }

    /**  */
    fun requestFilter(request : HttpServletRequest):Boolean{
        for( f in limiterFilters){
            val userId = request.getHeader("userId")
            val url = request.requestURL.toString()

            if(!f.isAccessible( TrafficMessage(userId , url) )){
                throw Exception("filter exception")
            }
        }
        return true
    }
}
