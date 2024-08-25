package com.mooop.m.ex3.repository

import com.mooop.m.ex3.repository.entity.Teacher
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Project: kmvc
 * Package :com.mooop.m.ex3.repository.entity
 * Author : mooopjjang
 * Date 2024/01/23
 * DESC :
 */
interface TeacherRepository : JpaRepository<Teacher, Long>{
}