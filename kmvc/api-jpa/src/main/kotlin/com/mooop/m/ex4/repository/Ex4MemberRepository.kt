package com.mooop.m.ex4.repository

import com.mooop.m.ex4.repository.entity.Ex4Member
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Project: kmvc
 * Package :com.mooop.m.ex4.repository.entity
 * Author : mooopjjang
 * Date 2024/01/24
 * DESC :
 */
interface Ex4MemberRepository : JpaRepository<Ex4Member , Long>{
}