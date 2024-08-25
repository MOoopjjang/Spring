package com.mooop.core.upload

import com.amazonaws.services.s3.AmazonS3Client
import com.mooop.core.upload.repository.UploadEntity
import com.mooop.core.upload.repository.UploadRepository
import com.mooop.core.upload.vo.FileAttachVo
import com.mooop.core.upload.vo.UploadProperties
import com.mooop.core.utils.DateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.InputStreamResource
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.io.File
import java.time.LocalDateTime
import java.time.ZoneId
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Project : kmvc
 * Package :com.mooop.core.upload
 * Author :  zinnaworks
 * Date : 28/04/2022
 * Desc :
 */
@Component("fileUploadProvider")
class FileUploadProvider{

    @Autowired
    private lateinit var amazonS3Client: AmazonS3Client
    @Autowired
    private lateinit var uploadRepository: UploadRepository
    @Autowired
    private lateinit var uploadProperties: UploadProperties

    @Value("\${cloud.aws.s3.bucket}")
    private lateinit var bucket:String

    private val uploadDetailsService:AbsFileUploadDetailsService by lazy {
        if(uploadProperties.mode == "s3"){
            S3UploadDetailsService(amazonS3Client , bucket , uploadProperties.tmpPath)
        }else{
            LocalUploadDetailsService()
        }
    }

    /**
     * 파일 upload 및 db insert
     */
    fun uploadAttachFile(serviceId:String , userId:String , refId:Long
                         , refType:String , mpf:MultipartFile):FileAttachVo{

        println("fileSource : $refId - fileKey:$refType")
        val rootPath:String = if(uploadProperties.mode == "s3"){
                uploadProperties.s3["root-path"] as String
            }else{
                uploadProperties.local["root-path"] as String
            }
        val dirPath:String = rootPath.plus("/")
            .plus(serviceId).plus("/")
            .plus(userId).plus("/")
            .plus(DateUtil.convertDateTimeToString(LocalDateTime.now(ZoneId.of("Asia/Seoul")) , "YYYYMMdd"))

        println("dirPath : $dirPath")
        val dF = File(dirPath)
        if(!dF.exists() || !dF.isDirectory){
            dF.mkdirs()
        }
        return uploadDetailsService.uploadFile(mpf , dirPath).also {
            it.refId = refId
            it.refType = refType

            /** DB에 저장 ... */
            val e = uploadRepository.saveAndFlush(UploadEntity.convertVoToEntity(it))
            it.id = e.id
        }
    }


    fun uploadAttachFiles(serviceId:String , userId:String , refId:Long
                          , refType:String , mpsr: MultipartHttpServletRequest
    ):List<FileAttachVo>{
        val fileAttachList:MutableList<FileAttachVo> = mutableListOf()
        mpsr.fileNames.forEach {
            var mFile = mpsr.getFile(it)
            fileAttachList.add(uploadAttachFile(serviceId , userId , refId , refType , mFile!!))
            Thread.sleep(100)
        }
        return fileAttachList
    }


    fun deleteAttachFile(fileId:Long):Boolean =
        uploadRepository.findById(fileId)?.let{
            val uploadEntity = it.get()
            uploadDetailsService.deleteFile(uploadEntity.filePath)
            uploadRepository.delete(uploadEntity)
            true
        }?:false



    fun deleteAttachFiles(fileIds:Array<Long>):Boolean{
        for(fileId in fileIds){
            deleteAttachFile(fileId)
            Thread.sleep(100)
        }
        return true
    }


    /**
     * 첨부파일을 다운로드한다
     */
    fun downloadAttachFile(fileId:Long , request: HttpServletRequest , response:HttpServletResponse):
            ResponseEntity<InputStreamResource> =
        uploadRepository.findById(fileId)
            ?.let{
                val userEntity = it.get()
                uploadDetailsService.downloadFile(userEntity.filePath , request , response)
            }?:throw IllegalArgumentException("파일정보가 존재하지 않습니다.")


    /**
     * upload한 파일의 정보들을 반환한다.
     */
    fun getAttachFilesInfo(refId:Long , refType:String):List<FileAttachVo> =
        uploadRepository.findByRefIdAndRefType(refId , refType)
            ?.let{
                val rl = mutableListOf<FileAttachVo>()
                it.map { data->
                    rl.add(FileAttachVo.convertEntityToVo(data))
                    return rl
                }
            }


    /**
     * upload한 파일의 정보들을 반환한다.
     */
    fun getAttachFileInfo(fileId:Long):FileAttachVo? =
        uploadRepository.findById(fileId)
            ?.get().let {
                FileAttachVo.convertEntityToVo(it)
            }

}