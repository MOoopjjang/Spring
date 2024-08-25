package com.mooop.m.ex5.factory

import com.mooop.m.ex5.controller.vo.MovieReq
import com.mooop.m.ex5.repository.entity.Movie

class MovieFactory {

    companion object{
        fun generateMovieEntity(movie:MovieReq) : Movie =
                Movie().apply {
                    name = movie.name
                    price = movie.price
                    director = movie.director
                    actor = movie.actor
                }
    }
}