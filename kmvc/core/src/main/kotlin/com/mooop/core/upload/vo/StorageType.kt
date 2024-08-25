package com.mooop.core.upload.vo

/**
 * Project : kmvc
 * Package :com.mooop.core.upload.vo
 * Author :  zinnaworks
 * Date : 27/04/2022
 * Desc :
 */
enum class StorageType constructor(val code:String){
    LOCAL ("local"),
    S3 ("s3")
}