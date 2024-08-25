package com.mooop.m.t2.repository

import javax.persistence.Embeddable

/**
 * Project : kmvc
 * Package :com.mooop.m.t2.repository
 * Author :  mooop
 * Date : 03/05/2022
 * Desc :
 */
@Embeddable
class Address constructor(
    var city:String? = null,
    var zipCode:String?=null,
    var street:String?=null
)