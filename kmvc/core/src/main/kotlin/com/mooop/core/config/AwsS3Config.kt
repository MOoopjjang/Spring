package com.mooop.core.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Project : kmvc
 * Package :com.mooop.core.config
 * Author :  zinnaworks
 * Date : 28/04/2022
 * Desc :
 */
@Configuration
class AwsS3Config {
    @Value("\${cloud.aws.credentials.access-key}")
    lateinit var accessKey:String
    @Value("\${cloud.aws.credentials.secret-key}")
    lateinit var secretKey:String
    @Value("\${cloud.aws.region.static}")
    lateinit var region:String

    @Bean
    fun amazonS3Client():AmazonS3Client =
        BasicAWSCredentials(accessKey , secretKey).let {
            AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(AWSStaticCredentialsProvider(it))
                .build() as AmazonS3Client
        }
}