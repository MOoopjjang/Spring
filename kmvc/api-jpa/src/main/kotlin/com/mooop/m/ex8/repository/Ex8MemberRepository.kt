package com.mooop.m.ex8.repository

import com.mooop.m.ex8.repository.entity.Ex8Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.repository
 * Author : mooopjjang
 * Date 2024/03/11
 * DESC :
 */
interface Ex8MemberRepository : JpaRepository<Ex8Member , Long> , JpaSpecificationExecutor<Ex8Member> {
}