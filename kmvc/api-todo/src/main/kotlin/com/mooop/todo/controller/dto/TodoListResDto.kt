package com.mooop.todo.controller.dto

data class TodoListResDto(
        var totalCount:Int,
        var list:MutableList<TodoDto>
)
