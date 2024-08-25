package com.mooop.core.upload.vo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Project : kmvc
 * Package :com.mooop.core.upload.vo
 * Author :  zinnaworks
 * Date : 28/04/2022
 * Desc :
 */
@Component("uploadProperties")
@ConfigurationProperties(prefix = "upload")
class UploadProperties {

    lateinit var tmpPath:String

    lateinit var mode:String

    lateinit var local:Map<String , String>

    lateinit var s3:Map<String , String>
}