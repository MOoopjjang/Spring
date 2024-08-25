package com.mooop.core.repository

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

/**
 * Project : kmvc
 * Package :com.mooop.core.repository
 * Author :  zinnaworks
 * Date : 27/04/2022
 * Desc :
 */
@MappedSuperclass
abstract class BasicEntity {

    @JsonFormat(shape=JsonFormat.Shape.STRING , pattern="yyyy-MM-ddHH:mm:ss" , timezone="Asia/Seoul")
    @CreationTimestamp
    @Column(name = "CREATE_DT")
    val createDt: LocalDateTime?=null;

    @JsonFormat(shape=JsonFormat.Shape.STRING , pattern="yyyy-MM-ddHH:mm:ss" , timezone="Asia/Seoul")
    @UpdateTimestamp
    @Column(name = "UPDATE_DT")
    val updateDt: LocalDateTime?=null


}