package com.mooop.m.ex3.repository

import com.mooop.m.ex3.repository.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Project: kmvc
 * Package :com.mooop.m.ex3.repository
 * Author : mooopjjang
 * Date 2024/01/23
 * DESC :
 */
interface StudentRepository : JpaRepository<Student , Long> {
}