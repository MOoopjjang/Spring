package com.mooop.core.auth.repository

import com.mooop.core.auth.vo.RoleType
import com.mooop.core.repository.BasicEntity
import org.hibernate.annotations.DynamicInsert
import javax.persistence.*

/**
 * Project : kmvc
 * Package :com.mooop.core.auth.repository
 * Author :  zinnaworks
 * Date : 30/04/2022
 * Desc :
 */
@Entity
@Table(name = "AUTHENTICATION")
@DynamicInsert
class AuthEntity : BasicEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDX")
    var id:Long? = 0

    @Column(name = "USERNAME")
    var username:String = ""

    @Column(name = "EMAIL")
    var email:String = ""

    @Column(name = "PASSWORD")
    var password:String = ""

    @Column(name = "ROLE_TYPE")
    @Enumerated(EnumType.STRING)
    var roleType:RoleType = RoleType.USER
}