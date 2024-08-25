package com.mooop.m.ex8.repository

import com.mooop.m.ex8.repository.entity.Ex8Family
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.repository
 * Author : mooopjjang
 * Date 2024/03/19
 * DESC :
 */
interface Ex8FamilyRepository : JpaRepository<Ex8Family , Long> {
}