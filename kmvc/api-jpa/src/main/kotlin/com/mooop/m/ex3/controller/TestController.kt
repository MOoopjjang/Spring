package com.mooop.m.ex3.controller

import com.mooop.m.ex3.repository.StudentRepository
import com.mooop.m.ex3.repository.TeacherRepository
import com.mooop.m.ex3.repository.entity.Student
import com.mooop.m.ex3.repository.entity.Teacher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Project: kmvc
 * Package :com.mooop.m.ex3.repository.controller
 * Author : mooopjjang
 * Date 2024/01/23
 * DESC :
 */

@RestController
@RequestMapping("/ex3/test")
class TestController constructor(
    val teacherRepository: TeacherRepository
    ,val studentRepository: StudentRepository
){

    @GetMapping("/t1")
    fun registry() : String{

        val s1 = Student(name = "aaaa" , age = 10 , level = 4)
        studentRepository.save(s1)
        val s2 = Student(name = "bbbb" , age = 10 , level = 4)
        studentRepository.save(s2)


        val teacher = Teacher(
            name = "cwkim", age = 35 , subject = "Math"
        )

        teacher.students.add(s1)
        teacher.students.add(s2)
        teacherRepository.save(teacher)
        return "SUCCESS"
    }
}