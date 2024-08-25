package com.mooop.core.upload

import com.mooop.core.upload.vo.FileAttachVo
import com.mooop.core.upload.vo.StorageType
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.net.URLConnection
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.core.upload
 * Author :  zinnaworks
 * Date : 27/04/2022
 * Desc : Local Storage에 파일업로드 기능을 제공하는 class
 */
class LocalUploadDetailsService : AbsFileUploadDetailsService() {

    override fun uploadFile(mpsr: MultipartFile, dirPath: String): FileAttachVo {
        val orgFilename:String = mpsr.originalFilename!!
        val targetFilename:String = generateTargetname(orgFilename)
        val extension = getExtension(orgFilename)
        val filePath = dirPath.plus("/").plus(targetFilename)

        val f:File = File(filePath)
        /** 파일 저장... */
        mpsr.transferTo(f)

        return FileAttachVo().apply {
            this.orgFilename = orgFilename
            this.fileExt = extension
            this.filePath = filePath
            this.fileSize = mpsr.size
            this.targetFilename = targetFilename
            this.storageType = StorageType.LOCAL
        }

    }

    override fun downloadFile(filePath: String, request: HttpServletRequest
                              , response: HttpServletResponse
                            ): ResponseEntity<InputStreamResource>? {
        val f:File = File(filePath)
        if(f.exists()){
            val mimeType = URLConnection.guessContentTypeFromName(f.name)?:"application/octet-stream"

            val resource:Resource = UrlResource(f.toURI())
            return HttpHeaders().apply {
                this.contentType = MediaType.parseMediaType(mimeType)
                this.cacheControl = "no-cache"
                this.contentLength = resource.contentLength()
                this.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + resource.getFilename() + "\"")
            }.let {
                val isr:InputStreamResource = InputStreamResource(FileInputStream(f))
                ResponseEntity.ok().headers(it).body(isr)
            }
        }else{
            println("file does not exist!!!")
        }
        return null
    }

    override fun deleteFile(filePath: String) {
        val f:File  = File(filePath)
        if(f.exists() && f.isFile){
            f.delete()
        }
    }
}