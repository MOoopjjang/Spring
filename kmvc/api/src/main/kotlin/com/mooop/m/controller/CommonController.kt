package com.mooop.m.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

/**
 * Project: kmvc
 * Package :com.mooop.m.controller
 * Author : mooopjjang
 * Date 2024/03/12
 * DESC :
 */

@ControllerAdvice
class CommonController {

    val logger = LoggerFactory.getLogger(CommonController::class.java)

    @ModelAttribute("getUserId")
    fun getUserId():String {
        logger.info(">>>>>>> CommonController --> getUserId() Called!!!!!!!!!!!")
        return "xferlog";
    }

}