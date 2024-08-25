package com.mooop.core.auth.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Project : kmvc
 * Package :com.mooop.core.auth.repository
 * Author :  zinnaworks
 * Date : 30/04/2022
 * Desc :
 */
@Repository
interface AuthenticationRepository : JpaRepository<AuthEntity , Long> {

    fun findByEmail(email:String):AuthEntity?
}