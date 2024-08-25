package com.mooop.w.t1

import com.mooop.w.t1.domain.UserDetailService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/t1/main")
class T1MainController constructor(
    val userDetailService: UserDetailService
){

    @GetMapping("")
    fun main(model : Model) : String {

        if(userDetailService.login){
            model.addAttribute("username" , userDetailService.username())
            model.addAttribute("password" , userDetailService.password())
            return "t1/main"
        }else{
            return "t1/login"
        }
    }

}