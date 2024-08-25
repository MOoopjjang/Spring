package com.mooop.rd1.controller

import com.mooop.core.vo.ApiResponse
import com.mooop.rd1.controller.model.StudentVo
import com.mooop.rd1.repository.StudentRepository
import com.mooop.rd1.repository.entity.Student
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Project: kmvc
 * Package :com.mooop.rd1.controller
 * Author : mooopjjang
 * Date 2023/09/29
 * DESC :
 */

@RestController
@RequestMapping("/student")
class StudentController constructor(
    val studentRepository: StudentRepository
){

    val logger = LoggerFactory.getLogger(StudentController::class.java)

    @PostMapping("/save")
    fun  save(@RequestBody param : StudentVo) : ApiResponse<Map<String , Any>>{
        logger.info(">> param = {}" , param.toString())


        val c = studentRepository.save(Student().apply {
            this.name = param.name
            this.age = param.age
            this.addr = param.addr
            this.score = param.score
        })

        logger.info(">>c = {}" , c.toString())
        return ApiResponse.ok(mapOf("result" to "OK" , "count" to 1))
    }
}