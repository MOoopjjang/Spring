package com.mooop.m.t2.repository

import org.hibernate.annotations.DynamicInsert
import javax.persistence.*

/**
 * Project : kmvc
 * Package :com.mooop.m.t2.repository
 * Author :  mooop
 * Date : 02/05/2022
 * Desc :
 */
@Entity
@Table(name = "TB_T2")
@DynamicInsert
class T2 {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDX")
    var idx:Long?=null

    @Column(name = "NAME")
    var name:String?=null

    @Column(name = "AGE")
    var age:Int? = null

    @Column(name = "CODE")
    var code:String?=null

    @Embedded
    @Column(name = "HOME_ADDRESS")
    var homeAddress:Address? = null

    @Column(name = "JOB")
    var job:String?=null
}