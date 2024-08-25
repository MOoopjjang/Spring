package com.mooop.board.api

import com.mooop.board.api.dto.PostResDto
import com.mooop.board.api.dto.User
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
class PostController {


    @GetMapping("/posts")
    fun posts() : List<PostResDto> = postCache

    @GetMapping("/post/{postId}")
    fun post(@PathVariable postId:Int) : PostResDto? = postCache.first { d->d.id == postId }

    companion object {
        val user1 = User("cwkim" , 20)
        val user2 = User("ejkim" , 20)
        val user3 = User("bhkim" , 30)
        val user4 = User("khlee" , 40)

        val postCache = listOf<PostResDto>(
            PostResDto(1,"title1","content1" , LocalDateTime.now() ,  user1)
            ,PostResDto(2,"title2","content2" ,LocalDateTime.now() , user2)
            ,PostResDto(3,"title3","content3" ,LocalDateTime.now() , user3)
            ,PostResDto(4,"title4","content4" ,LocalDateTime.now() , user4)
        )
    }

}