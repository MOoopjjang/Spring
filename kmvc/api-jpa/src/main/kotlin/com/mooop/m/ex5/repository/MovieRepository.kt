package com.mooop.m.ex5.repository

import com.mooop.m.ex5.repository.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie , Long>{
}