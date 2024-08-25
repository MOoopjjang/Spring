package com.mooop.m.ex5.controller

import com.mooop.m.ex5.controller.vo.MovieReq
import com.mooop.m.ex5.factory.MovieFactory
import com.mooop.m.ex5.repository.MovieRepository
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/ex5/movie")
class MovieController constructor(
        val moveRepository: MovieRepository
){

    val log = LoggerFactory.getLogger(MovieController::class.java)

    @PostMapping("")
    fun registry(@RequestBody movie: MovieReq) : String{
        val e = MovieFactory.generateMovieEntity(movie)
        log.info(">>> entity = {}" , e.toString())
        moveRepository.save(e)
        return "SUCCESS"
    }
}