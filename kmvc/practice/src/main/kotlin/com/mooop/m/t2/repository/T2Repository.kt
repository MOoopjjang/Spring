package com.mooop.m.t2.repository

import com.mooop.m.t2.dto.T2Dto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Project : kmvc
 * Package :com.mooop.m.t2.repository
 * Author :  mooop
 * Date : 02/05/2022
 * Desc :
 */
interface T2Repository : JpaRepository<T2 , Long> {

    @Query("select t2 from T2 as t2 where t2.name=:name")
    fun findByName(@Param("name") name:String):T2?

    @Query("select t2 from T2 as t2 where t2.homeAddress.city=:city")
    fun findByCity(@Param("city") city:String):List<T2>?

    @Query("select new com.mooop.m.t2.dto.T2Dto(t2.idx , t2.name , t2.age , t2.code , t2.homeAddress.city , t2.homeAddress.zipCode , t2.homeAddress.street , t2.job) from T2 as t2 where t2.name=:name")
    fun findByName2(@Param("name") name:String):T2Dto?


    @Query("select t2 from T2 t2,T22 t22 where t22.name=t2.name")
    fun findByName3():List<T2>?

    @Query("select t2 from T2 t2 left join T22 t22 on t2.idx=t22.idx")
    fun findBylj():List<T2>?
}