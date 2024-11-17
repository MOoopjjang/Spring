package com.mooop.m.infra.filters.traffic

import com.mooop.m.infra.filters.traffic.dto.AccessHistoryDto
import com.mooop.m.infra.filters.traffic.dto.TrafficMessage
import com.mooop.m.infra.filters.traffic.impl.GlobalTrafficFilter
import com.mooop.m.infra.filters.traffic.impl.UserTrafficFilter
import com.mooop.m.infra.filters.traffic.query.TrafficFilterQueryInterface
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest


@Component
class TrafficLimitFilterChain constructor(
    private val globalTrafficFilter: GlobalTrafficFilter
    ,private val userTrafficFilter: UserTrafficFilter
    ,private val trafficFilterQueryInterface: TrafficFilterQueryInterface
){

    val log = LoggerFactory.getLogger(TrafficLimitFilterChain::class.java)
    /**  */
    private val limiterFilters:MutableList<TrafficLimitFilter> by lazy { mutableListOf() }


    @PostConstruct
    fun initialize(){
        limiterFilters.add(globalTrafficFilter)
        limiterFilters.add(userTrafficFilter)

        /** 우선순위로 정렬 */
        val comparator:Comparator<TrafficLimitFilter> = compareBy{it.getPriority()}
        limiterFilters.sortWith(comparator)
    }

    fun register(@Autowired filter: TrafficLimitFilter){
        limiterFilters.add(filter)
    }

    /** 등록된 filter 실행 */
    fun exec(request : HttpServletRequest):Boolean{
        for( f in limiterFilters){
            val userId = request.getHeader("userId")
            val url = request.requestURL.toString()
            f.isAccessible( TrafficMessage(userId , url) )
        }

        // TODO : code 이동 필요!!!
        trafficFilterQueryInterface.registry(AccessHistoryDto(
            request.getHeader("userId")
            ,request.requestURL.toString()
            ,LocalDateTime.now()
            )
        )


        return true
    }
}