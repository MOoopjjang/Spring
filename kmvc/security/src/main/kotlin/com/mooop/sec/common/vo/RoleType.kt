package com.mooop.sec.common.vo

/**
 * Project : kmvc
 * Package :com.mooop.sec.common.vo
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
enum class RoleType constructor(var code:String){
    ADMIN ("ROLE_ADMIN"),
    USER ("ROLE_USER"),
    GUEST ("ROLE_GUEST");


}