package com.mooop.m.feature.manager.impl

import com.mooop.m.feature.manager.UserAccessHistoryInterface
import com.mooop.m.feature.manager.dto.CheckOverAccessLimit
import com.mooop.m.feature.manager.model.UserAccessInfo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class UserAccessHistoryDomain : UserAccessHistoryInterface {
    val log = LoggerFactory.getLogger(UserAccessHistoryDomain::class.java)

    private val userAccessInfoMapper:MutableMap<String , MutableList<UserAccessInfo>> by lazy { mutableMapOf() }

    override fun registry(accessInfo: UserAccessInfo): Boolean =
        userAccessInfoMapper.get(accessInfo.userId)?.let { info->
            info.add(accessInfo)
            true
        }?:let {
            userAccessInfoMapper[accessInfo.userId] = mutableListOf(accessInfo)
            true
        }


    override fun retrieveUser(userId: String): List<UserAccessInfo>  =
        userAccessInfoMapper.get(userId)?: listOf()


    override fun existUserAccessHistory(userId: String): Boolean =
        userAccessInfoMapper.get(userId)?.let { true }?:let { false }


    /**
     * 유저가 접속가능한지 접속제한 체크
     */
    override fun checkOverAccessLimit(checkOverAccessLimit: CheckOverAccessLimit): Boolean {
        val (userId , _ , checkOverAccessLimit , limitCount) = checkOverAccessLimit
        log.info(">>>> userId :{} , checkOverAccessLimit : {} , limitCount : {}",userId,checkOverAccessLimit,limitCount)
        if(userAccessInfoMapper.isEmpty() || userAccessInfoMapper.get(userId).isNullOrEmpty()){
            return false
        }else{
            val now = LocalDateTime.now()
            val targetTime = LocalDateTime.now().minusSeconds(checkOverAccessLimit.toLong())
            val accessInfos = userAccessInfoMapper.get(userId)!!
            log.info(">>> accessInfo : {}",accessInfos.size)
            var accessCount : Int = 0
            for(  v in accessInfos){
                if(v.accessTime.isBefore(now) && v.accessTime.isAfter(targetTime)){
                    accessCount++
                }
            }
            log.info(">>> accessCount : {} , limitCount : {}",accessCount ,limitCount )

            return accessCount < limitCount
        }

    }
}
