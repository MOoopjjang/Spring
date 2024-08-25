package com.mooop.m.t2.dto

import com.mooop.m.t2.repository.T2

/**
 * Project : kmvc
 * Package :com.mooop.m.t2.dto
 * Author :  mooop
 * Date : 02/05/2022
 * Desc :
 */
class T2Dto constructor(
    var idx:Long?=null,
    var name:String?=null,
    var age:Int? = null,
    var code:String?=null,
    var city:String?=null,
    var zipCode:String?=null,
    var street:String?=null,
    var job:String?=null
){
    companion object{
        fun convertEntityToDto(entity: T2):T2Dto =
            T2Dto().apply {
                this.idx = entity.idx
                this.name = entity.name
                this.age = entity.age
                this.code = entity.code
                this.job = entity.job
                if(entity.homeAddress != null){
                    this.city = entity.homeAddress!!.city
                    this.zipCode = entity.homeAddress!!.zipCode
                    this.street = entity.homeAddress!!.street
                }
            }
    }
}
