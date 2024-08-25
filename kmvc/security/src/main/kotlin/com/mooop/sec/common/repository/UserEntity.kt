package com.mooop.sec.common.repository

import com.fasterxml.jackson.annotation.JsonFormat
import com.mooop.sec.common.vo.RoleType
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

/**
 * Project : kmvc
 * Package :com.mooop.sec.common.repository
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@Entity
@Table(name = "K_USER")
class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDX")
    var id:Long? = 0

    @Column(name = "USERNAME")
    var username:String = ""

    @Column(name = "EMAIL")
    var email:String = ""

    @Column(name = "PASSWORD")
    var password:String = ""

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    var roleType:RoleType = RoleType.USER

    @JsonFormat(shape=JsonFormat.Shape.STRING , pattern="yyyy-MM-ddHH:mm:ss" , timezone="Asia/Seoul")
    @CreationTimestamp
    @Column(name = "CREATE_DT")
    var createDt:LocalDateTime?=null

}
