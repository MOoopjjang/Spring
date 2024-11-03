package com.mooop.m.facade

import com.mooop.m.feature.manager.dto.CheckOverAccessLimit
import com.mooop.m.feature.manager.impl.UserAccessHistoryDomain
import com.mooop.m.feature.manager.model.UserAccessInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
@RequestMapping("/tst")
class RequestLimitTestResource constructor(
    val userAccessHistoryDomain: UserAccessHistoryDomain
){

    @GetMapping("/")
    fun t1():ResponseEntity<Boolean>{

        userAccessHistoryDomain.registry(UserAccessInfo("cwkim" , "/aaaa" , LocalDateTime.now()))
        return ResponseEntity.ok().body(true)
    }

    @GetMapping("/{userId}")
    fun t2(@PathVariable userId:String):ResponseEntity<List<UserAccessInfo>>{
        return ResponseEntity.ok().body(userAccessHistoryDomain.retrieveUser(userId))
    }

    @GetMapping("/chk/{userId}")
    fun check(@PathVariable userId:String):ResponseEntity<Boolean>{
        val result = userAccessHistoryDomain.checkOverAccessLimit(CheckOverAccessLimit(userId , "/aaaa" , 30 , 4))
        return ResponseEntity.ok().body(result)
    }
}