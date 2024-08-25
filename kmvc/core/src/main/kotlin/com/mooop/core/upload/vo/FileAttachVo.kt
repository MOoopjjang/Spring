package com.mooop.core.upload.vo

import com.mooop.core.upload.repository.UploadEntity

/**
 * Project : kmvc
 * Package :com.mooop.core.upload.vo
 * Author :  zinnaworks
 * Date : 26/04/2022
 * Desc :
 */
data class FileAttachVo(
    var id:Long?=null,
    var refId:Long?=null,
    var refType:String="",
    var filePath:String="",
    var fileUrl:String="",
    var orgFilename:String="",
    var targetFilename:String="",
    var fileExt:String?=null,
    var storageType:StorageType?=null,
    var fileSize:Long=0
){
    companion object{
        fun convertEntityToVo(entity:UploadEntity):FileAttachVo =
            FileAttachVo().apply {
                this.id = entity.id
                this.refId = entity.refId
                this.refType = entity.refType
                this.filePath = entity.filePath
                this.fileUrl = entity.fileUrl?:""
                this.orgFilename = entity.orgFilename
                this.targetFilename = entity.targetFilename
                this.fileExt = entity.fileExt
                this.storageType = entity.storageType
                this.fileSize = entity.fileSize

            }
    }
}



