package com.mooop.es.e1.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RestController
@RequestMapping("/postback")
class RedirectPostbackController {

    val LOGGER = LoggerFactory.getLogger(RedirectPostbackController::class.java)

//    @GetMapping("/actionlog")
//    fun receivePostback(
//         @RequestParam("tokenId" , required = true) tokenId:String
//        ,@RequestParam("item1" , required = true) item1:String
//        ,@RequestParam("item2" , defaultValue = "" ,  required = false) item2:String
//        ,@RequestParam("item3" , defaultValue = "" ,  required = false) item3:String
//        ,@RequestParam("item4" , defaultValue = "" ,  required = false) item4:String
//    ):String{
//        LOGGER.info(" tokenId = {}, item1 = {},item2 = {},item3 = {},item4 = {}" , tokenId, item1,item2,item3,item4)
//        return "OK"
//    }

    @PostMapping("/actionlog")
    fun receivePostback(@RequestBody postBackResDto: PostBackResDto):String{
        LOGGER.info("postBackResDto = {}" , postBackResDto.toString())
        return "OK"
    }



    data class PostBackResDto(
            val tokenId:String? = null,
            var item1:String?=null,
            var item2:String? = null,
            var item3:String? = null,
            var item4:String? = null
    )
}