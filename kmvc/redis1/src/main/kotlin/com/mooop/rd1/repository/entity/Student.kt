package com.mooop.rd1.repository.entity

import org.hibernate.annotations.ValueGenerationType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * Project: kmvc
 * Package :com.mooop.rd1.repository.entity
 * Author : mooopjjang
 * Date 2023/09/29
 * DESC :
 */

@Entity
@Table(name="TB_STUDENT")
class Student {

    @Id
    @GeneratedValue
    var id:Long? = 0

    var name:String? = null
    var age:Int? = 0
    var addr:String?=null
    var score:Int? = 0

    override fun toString(): String {
        return "name : ".plus(this.name).plus(" , age=").plus(this.age).plus(", addr=").plus(this.addr)
    }

}