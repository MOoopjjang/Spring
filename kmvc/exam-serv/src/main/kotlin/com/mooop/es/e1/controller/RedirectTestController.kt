package com.mooop.es.e1.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*


@Controller
class RedirectTestController {

    @GetMapping("/redirect/landing/{randomPath}")
    fun landingPage(@PathVariable randomPath:String , model:Model) : String{
        val tokenId = UUID.randomUUID().toString().replace("-","")
        model.addAttribute("randomPath" , randomPath)
        model.addAttribute("tokenId" , tokenId)
        return campaignType(randomPath)?.let {
            "redirect:http://localhost:9089/ex1/landing?tokenId=".plus(tokenId)
        }?:"landing"
    }


    private fun campaignType(randomPath:String) : String?{
        return if(randomPath.startsWith("cpa")){
            "cpa"
        }else{
            null
        }
    }
}