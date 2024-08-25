package com.mooop.core.upload

import com.mooop.core.upload.vo.FileAttachVo
import org.springframework.core.io.InputStreamResource
import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile
import java.lang.StringBuilder
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.core.upload
 * Author :  zinnaworks
 * Date : 26/04/2022
 * Desc :
 */
abstract class AbsFileUploadDetailsService {


    /**
     * 확장자를 반환한다.
     */
    fun getExtension(fileName:String):String? = fileName?.substring(fileName.lastIndexOf("."))?:null


    /**
     * 변조된 파일이름을 반환한다.
     */
    fun generateTargetname(fileName:String):String =
        UUID.randomUUID().toString().replace("-" , "").plus("_$fileName")


    /**
     * 파일명이 한글일 경우 URL encode가 필요함
     */
    fun getEncoderFilename(request:HttpServletRequest , displayName:String):String{
       val header:String = request.getHeader("User-Agent")
       var encodedFilename:String = ""
       if(header.indexOf("MSIE") > -1){
           encodedFilename = URLEncoder.encode(displayName , "UTF-8").replace("\\+" , "%20");
       }else if(header.indexOf("Trident") > -1){
           encodedFilename = URLEncoder.encode(displayName , "UTF-8").replace("\\+" , "%20");
       }else if(header.indexOf("Chrome") > -1){

           val sb:StringBuilder =  StringBuilder()
           for(i in 0..displayName.length){
               val c:Char = displayName[i]
               if(c == '~'){
                   sb.append(URLEncoder.encode(""+c , "UTF-8"));
               }else{
                   sb.append(c);
               }
           }
           encodedFilename = sb.toString();
       }else if(header.indexOf("Opera") > -1){
           encodedFilename = "\""+String(displayName.toByteArray(StandardCharsets.UTF_8) , StandardCharsets.ISO_8859_1)+"\""
       }else if(header.indexOf("Safari") > -1){
           encodedFilename = URLDecoder.decode("\""+String(displayName.toByteArray(StandardCharsets.UTF_8) , StandardCharsets.ISO_8859_1)+"\"", "UTF-8")
       }else{
           encodedFilename = URLDecoder.decode("\""+String(displayName.toByteArray(StandardCharsets.UTF_8) , StandardCharsets.ISO_8859_1)+"\"", "UTF-8")
       }
        return encodedFilename
    }


    /**
     *  upload
     */
    abstract fun uploadFile(mpsr:MultipartFile , dirPath:String):FileAttachVo

    /**
     * download
     */
    abstract fun downloadFile(filePath:String
                              , request:HttpServletRequest
                              , response:HttpServletResponse):ResponseEntity<InputStreamResource>?

    /**
     * 삭제
     */
    abstract fun deleteFile(filePath:String):Unit

}