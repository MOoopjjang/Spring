package com.mooop.m.t1.controller

import com.mooop.core.upload.FileUploadProvider
import com.mooop.core.vo.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartHttpServletRequest
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.m.controller
 * Author :  zinnaworks
 * Date : 28/04/2022
 * Desc : upload test sample ( local storage / S3 )
 */
@Controller
@RequestMapping( "/upload")
class UploadController @Autowired constructor(val fileUploadProvider: FileUploadProvider){

    @GetMapping("/t1")
    fun upload(request:HttpServletRequest , response:HttpServletResponse , model: Model):String{

        val refId:Long? = request.getParameter("refId")?.let{it.toLong()}?:null
        val refType:String? = request.getParameter("refType")?:null

        if(refId != null){
            model.addAttribute("xdata" ,fileUploadProvider.getAttachFilesInfo(refId , refType!!))
        }
        return "upload"
    }

    @PostMapping("/proc")
    fun proc(@RequestParam param:Map<String , String> , request: MultipartHttpServletRequest):String{
        val refId:Long = param["refId"]!!.toLong()
        val refType:String = param["refType"]!!

        println("refId : $refId , refType:$refType")

        fileUploadProvider.uploadAttachFiles("p" , "cwkim" , refId , refType , request)
        return "redirect:/upload/t1?refId=".plus(refId).plus("&refType=").plus(refType)
    }

    @GetMapping("/download/{id}")
    @ResponseBody
    fun download(@PathVariable id:String , request:HttpServletRequest
                 , response:HttpServletResponse):ResponseEntity<InputStreamResource> =
        fileUploadProvider.downloadAttachFile(id.toLong() , request , response)


    @GetMapping("/delete/{id}")
    @ResponseBody
    fun delete(@PathVariable id:String , request:HttpServletRequest):ApiResponse<String>{
        fileUploadProvider.deleteAttachFile(id.toLong())
        return ApiResponse.ok("SUCCESS")
    }
}