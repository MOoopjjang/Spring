package com.mooop.core.upload

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.*
import com.amazonaws.util.IOUtils
import com.mooop.core.upload.vo.FileAttachVo
import com.mooop.core.upload.vo.StorageType
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile
import java.io.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.core.upload
 * Author :  zinnaworks
 * Date : 27/04/2022
 * Desc : AWSn S3에 upload
 */
class S3UploadDetailsService constructor(
    val amazonS3Client: AmazonS3Client,
    val bucket:String,
    val tmpPath:String
) : AbsFileUploadDetailsService() {


    override fun uploadFile(mpsr: MultipartFile, dirPath: String): FileAttachVo {
        val uploadFile:File = convert(mpsr)?:throw IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다.")

        val orgFilename:String = mpsr.originalFilename!!
        val targetFilename:String = generateTargetname(orgFilename)
        val extension = getExtension(orgFilename)
        val filePath = dirPath.plus("/").plus(targetFilename)

        amazonS3Client.putObject(PutObjectRequest(bucket , filePath , uploadFile)
            .withCannedAcl(CannedAccessControlList.PublicRead))

        return FileAttachVo().apply {
            this.orgFilename = orgFilename
            this.targetFilename = targetFilename
            this.fileExt = extension
            this.filePath = filePath
            this.storageType = StorageType.S3
            this.fileUrl = amazonS3Client.getUrl(bucket , filePath).toString()
            this.fileSize = mpsr.size
        }.also {
            removeTmpFile(uploadFile)
        }
    }

    override fun downloadFile(filePath: String
                              , request: HttpServletRequest
                              , response: HttpServletResponse
    ): ResponseEntity<InputStreamResource> {
        val s3Object = amazonS3Client.getObject(bucket , filePath)
            ?:throw AmazonS3Exception("다운로드 파일이 존재하지 않습니다.")

        val s3ObjectInputStream:S3ObjectInputStream = s3Object.objectContent
        val bytes:ByteArray = IOUtils.toByteArray(s3ObjectInputStream)
        val ss = filePath.split("/")


        return HttpHeaders().apply {
            this.contentType = MediaType.parseMediaType("application/octet-stream")
            this.cacheControl = "no-cache"
            this.contentLength = s3Object.objectMetadata.contentLength
            this.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + ss[ss.size-1] + "\"")
        }.let {
            s3ObjectInputStream.close()
            val isr: InputStream = ByteArrayInputStream(bytes)
            ResponseEntity.ok().headers(it).body(InputStreamResource(isr))
        }
   }

    override fun deleteFile(filePath: String) {
        DeleteObjectRequest(bucket , filePath)
            .also {
                amazonS3Client.deleteObject(it)
            }
    }


    private fun removeTmpFile(dFile:File):Unit{
        dFile.delete()
    }

    private fun convert(mpsr:MultipartFile): File? {
        val cfile:File = File(tmpPath.plus("/").plus(mpsr.originalFilename))
        if(cfile.createNewFile()){
            FileOutputStream(cfile).apply {
                this.write(mpsr.bytes)
                this.close()
            }
            return cfile
        }
        return null
    }
}