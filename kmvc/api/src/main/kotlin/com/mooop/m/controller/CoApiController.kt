package com.mooop.m.controller

import com.mooop.m.controller.vo.MUser
import com.mooop.m.controller.vo.Score
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Project: kmvc
 * Package :com.mooop.api.controller
 * Author : mooopjjang
 * Date 2023/11/30
 * DESC : co-routine TEST IF 제공
 */

@RestController
@RequestMapping("/co/api")
class CoApiController {

    val log = LoggerFactory.getLogger(CoApiController::class.java)

    @GetMapping("/user/{userid}")
    suspend fun userInfo(@PathVariable userid:String) : MUser {
        log.info(">>>> userInfo called!!!")
        delay(3000)
        return MUser("xferlog" , 10 , "incheon")
    }


    @GetMapping("/score/{userid}")
    suspend fun scoreInfo(@PathVariable userid:String) : Score {
        log.info(">>>> scoreInfo called!!!")
        delay(5000)
        return Score(70 , 30 , 100)
    }

}