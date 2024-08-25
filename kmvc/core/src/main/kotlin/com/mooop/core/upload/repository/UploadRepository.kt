package com.mooop.core.upload.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Project : kmvc
 * Package :com.mooop.core.upload.repository
 * Author :  zinnaworks
 * Date : 28/04/2022
 * Desc :
 */
@Repository
interface UploadRepository : JpaRepository<UploadEntity , Long> {

     fun findByRefIdAndRefType(refId:Long , refType:String):List<UploadEntity>
}