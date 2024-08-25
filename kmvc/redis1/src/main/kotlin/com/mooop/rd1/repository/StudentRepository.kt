package com.mooop.rd1.repository

import com.mooop.rd1.repository.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Project: kmvc
 * Package :com.mooop.rd1.repository.entity
 * Author : mooopjjang
 * Date 2023/09/29
 * DESC :
 */
interface StudentRepository : JpaRepository<Student , Long>{

//    fun findById(id:Long):Student

    fun findByName(name:String):Student

//    fun save(student: Student):Int

}