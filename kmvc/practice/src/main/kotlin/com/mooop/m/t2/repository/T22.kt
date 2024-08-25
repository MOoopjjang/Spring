package com.mooop.m.t2.repository

import com.mooop.core.repository.BasicEntity
import org.hibernate.annotations.DynamicInsert
import javax.persistence.*

/**
 * Project : kmvc
 * Package :com.mooop.m.t2.repository
 * Author :  mooop
 * Date : 17/05/2022
 * Desc :
 */

@Entity
@Table(name = "TB_T22")
@DynamicInsert
class T22 : BasicEntity(){
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDX")
    var idx:Long?=null

    @Column(name = "NAME")
    var name:String?=null

    @Column(name = "TITLE")
    var title:String? = null

    @Column(name = "CONTENT")
    var content:String? = null
}