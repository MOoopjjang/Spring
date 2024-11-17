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
 * 사용자별 적용되는 filter
 */
@Component
class UserTrafficFilter constructor(
    val trafficFilterQueryInterface: TrafficFilterQueryInterface
): TrafficLimitFilter {

    val log = LoggerFactory.getLogger(GlobalTrafficFilter::class.java)

    @Value("\${app.user.limit-time-section}")
    private lateinit var limitTimeSection:Integer
    @Value("\${app.user.limit-count}")
    private lateinit var limitCount:Integer
    @Value("\${app.user.priority}")
    lateinit var priority:Integer


    override fun getPriority(): Int  = priority.toInt()

    override fun isAccessible(trafficMessage: TrafficMessage): Boolean {
        log.info(">>>> UserTrafficFilter -> called!!!")

        return if(trafficFilterQueryInterface.count() == 0){
             true
        }else{

            val userHistory = trafficFilterQueryInterface.retrieveByUserId(trafficMessage.userId)
            if(userHistory.isEmpty()){
                true
            }

            var count:Int = 0
            val now = LocalDateTime.now()
            val target = now.minusSeconds(limitTimeSection.toLong())
            log.info(">> now : {} , target : {}" , now.toString() , target.toString())
            for( uh in userHistory){
                if((uh.createdAt.isEqual(target) || uh.createdAt.isAfter(target))
                    && (uh.createdAt.isBefore(now) || uh.createdAt.isEqual(now))){
                    count++;
                }
            }

            log.info(">>>> limitCount : {} , count : {}",limitCount,count)

            if(limitCount <= count){
                throw TrafficLimitFilterException(TrafficLimitExceptionCode.TRAFFIC_USER_EXCEPTION)
            }
            true
        }

    }

}