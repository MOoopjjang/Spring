package com.mooop.sec.common.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Project : kmvc
 * Package :com.mooop.sec.common.repository
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@Repository
interface UserRepository:JpaRepository<UserEntity , Long> {
    fun findByEmail(email:String):UserEntity?
}
