package com.mooop.m.infra.filters.traffic.impl

import com.mooop.m.infra.filters.traffic.query.TrafficFilterQueryInterface
import com.mooop.m.infra.filters.traffic.TrafficLimitFilter
import com.mooop.m.infra.filters.traffic.dto.TrafficMessage
import com.mooop.m.infra.filters.traffic.exception.TrafficLimitFilterException
import com.mooop.m.infra.filters.traffic.exception.code.TrafficLimitExceptionCode
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * 서비스 전체에 적용되는 필터
 */
@Component
class GlobalTrafficFilter constructor(
    val trafficFilterQueryInterface: TrafficFilterQueryInterface
) : TrafficLimitFilter {

    val log = LoggerFactory.getLogger(GlobalTrafficFilter::class.java)

//    @Value("\${app.global.enable}")
//    private lateinit var enable:Boolean
    @Value("\${app.global.limit-time-section}")
    private lateinit var limitTimeSection:Integer
    @Value("\${app.global.limit-count}")
    private lateinit var limitCount:Integer
    @Value("\${app.global.priority}")
    lateinit var priority:Integer


    override fun getPriority(): Int = priority.toInt()

    override fun isAccessible(trafficMessage: TrafficMessage): Boolean =
         if(trafficFilterQueryInterface.count() == 0){
             true
        }else{
            var accessCount:Int = 0
            val now = LocalDateTime.now()
            val target = LocalDateTime.now().minusSeconds(limitTimeSection.toLong())
            for( dto in trafficFilterQueryInterface.retrieveAll()){

                if((dto.createdAt.isBefore(now) || dto.createdAt.isEqual(now))
                    && (dto.createdAt.isAfter(target) || dto.createdAt.isEqual(target))
                ){
                    accessCount++
                }
            }
            log.info(">>>> accessCount : {} , limitCount : {}" ,accessCount , limitCount.toInt() )
             if(accessCount >= limitCount.toInt()){
                 throw TrafficLimitFilterException(TrafficLimitExceptionCode.TRAFFIC_GLOBAL_EXCEPTION)
             }
             true
        }

}