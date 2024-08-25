package com.mooop.todo.controller

import com.mooop.todo.controller.dto.TodoDto
import com.mooop.todo.controller.dto.TodoListResDto
import com.mooop.todo.controller.dto.TodoReqDto
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/todo")
class TodoController {

    val LOGGER = LoggerFactory.getLogger(TodoController::class.java)

    val cache:MutableList<TodoDto> = mutableListOf()

    @GetMapping("")
    fun todoList():ResponseEntity<TodoListResDto> = ResponseEntity.ok(TodoListResDto(cache.size , cache))


    @PostMapping("/regist")
    fun registTodo(@RequestBody reqDto: TodoReqDto):ResponseEntity<String>{
        LOGGER.info(">>> reqDto = {}" , reqDto)
        cache.add(TodoDto(cache.size , reqDto.title!!))
        return ResponseEntity.ok("SUCCESS")
    }

}