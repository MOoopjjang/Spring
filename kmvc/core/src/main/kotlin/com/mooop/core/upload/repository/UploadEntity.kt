package com.mooop.core.upload.repository

import com.mooop.core.repository.BasicEntity
import com.mooop.core.upload.vo.FileAttachVo
import com.mooop.core.upload.vo.StorageType
import org.hibernate.annotations.DynamicInsert
import javax.persistence.*

/**
 * Project : kmvc
 * Package :com.mooop.core.upload.repository
 * Author :  zinnaworks
 * Date : 26/04/2022
 * Desc :
 */
@Entity
@Table(name = "TB_UPLOAD")
@DynamicInsert
class UploadEntity : BasicEntity(){

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID" , nullable = false)
    var id:Long?=null

    @Column(name="REF_ID" , nullable = false)
    var refId:Long? = null

    @Column(name="REF_TYPE" , nullable = false)
    var refType:String=""

    @Column(name="FILE_PATH" , nullable = false)
    var filePath:String=""

    @Column(name="FILE_URL" , nullable = true)
    var fileUrl:String?=null

    @Column(name="ORG_FILENAME" , nullable = false)
    var orgFilename:String=""

    @Column(name="TARGET_FILENAME" , nullable = false)
    var targetFilename:String=""

    @Column(name="FILE_EXT" , nullable = false)
    var fileExt:String=""

    @Column(name="STORAGE_TYPE" , nullable = false)
    @Enumerated(EnumType.STRING)
    var storageType:StorageType = StorageType.LOCAL

    @Column(name="FILE_SIZE" , nullable = false)
    var fileSize:Long=0


    companion object{
        fun convertVoToEntity(fileAttachVo:FileAttachVo):UploadEntity =
            UploadEntity().apply {
                this.refId = fileAttachVo.refId
                this.refType = fileAttachVo.refType
                this.orgFilename = fileAttachVo.orgFilename
                this.filePath = fileAttachVo.filePath
                this.fileUrl = fileAttachVo.fileUrl
                this.targetFilename = fileAttachVo.targetFilename
                this.fileExt = fileAttachVo.fileExt!!
                this.storageType = fileAttachVo.storageType!!
                this.fileSize = fileAttachVo.fileSize
            }
    }

}