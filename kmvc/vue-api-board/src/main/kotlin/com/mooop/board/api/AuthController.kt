package com.mooop.board.api

import com.mooop.board.api.dto.SigninReqDto
import com.mooop.board.api.dto.SigninResDto
import com.mooop.board.api.dto.SignupReqDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
class AuthController {
    val LOGGER = LoggerFactory.getLogger(AuthController::class.java)

    @PostMapping("/signup")
    fun signup(@RequestBody param:SignupReqDto):String{
        LOGGER.info(">>> param = {}" , param.toString())
        return "SUCCESS";
    }

    @PostMapping("/signin")
    fun signin(@RequestBody param: SigninReqDto): SigninResDto =
        SigninResDto("SUCCESS" , "aaaabbbbccceeedslds")


}