package com.mooop.auth.controller

import com.mooop.auth.service.AuthService
import com.mooop.core.jwt.vo.JwtVo
import com.mooop.core.jwt.vo.TokenUserVo
import com.mooop.core.vo.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

/**
 * Project : kmvc
 * Package :com.mooop.auth.controller
 * Author :  mooop
 * Date : 29/04/2022
 * Desc :
 */
@RestController
@RequestMapping("/jwt")
class AuthController @Autowired constructor( val authService: AuthService){


    /**
     * JWT를 생성후 반환한다.
     */
    @PostMapping("/get")
    fun getToken(@RequestBody param:TokenUserVo  , request:HttpServletRequest):ApiResponse<JwtVo> =
        authService.getJwt(param)?.let {
            ApiResponse.ok(it)
        }?:ApiResponse.error("JWT-01")


    /**
     * Token의 유효성 결과반환
     */
    @PostMapping("/chk")
    fun validation(@RequestBody  token:String , request: HttpServletRequest):ApiResponse<String> =
        if(authService.chk(token)){
           ApiResponse.ok("OK")
        }else{
            ApiResponse.error("JWT-02")
        }
}