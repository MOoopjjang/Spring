package com.mooop.m.t2.controller

import com.mooop.core.vo.ApiResponse
import com.mooop.m.t2.dto.T2Dto
import com.mooop.m.t2.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

/**
 * Project : kmvc
 * Package :com.mooop.m.t2.controller
 * Author :  mooop
 * Date : 02/05/2022
 * Desc :
 */
@Profile(value = ["t2"])
@RestController
@RequestMapping("/t2")
class JpqlController @Autowired constructor(
    val t2Repository: T2Repository , val t22Repository: T22Repository
){

    @PostConstruct
    fun init():Unit{
        t2Repository.save(T2().apply {
            this.name = "cwkim"
            this.age = 45
            this.code = "CODE_EP"
            this.job = "PROGRAMMER"
            this.homeAddress = Address("incheon" , "032" , "a")
        })

        t2Repository.save(T2().apply {
            this.name = "bhkim"
            this.age = 50
            this.code = "CODE_EP"
            this.job = "MANAGER"
            this.homeAddress = Address("seoul" , "02" , "a")
        })

        t2Repository.save(T2().apply {
            this.name = "kkm"
            this.age = 38
            this.code = "CODE_SP"
            this.job = "PROGRAMMER"
            this.homeAddress = Address("incheon" , "032" , "b")
        })

        t22Repository.save(T22().apply {
            this.name = "bhkim"
            this.title = "hi"
            this.content="adafdafdaf"
        })

        t22Repository.save(T22().apply {
            this.name = "you"
            this.title = "hi"
            this.content="adafdafdaf"
        })

    }


    /**
     * Normal
     */
    @GetMapping("/s/name")
    fun searchName(request:HttpServletRequest) : ApiResponse<T2Dto> =
        request.getParameter("name")
            ?.let{
                t2Repository.findByName(it)?.let{ entity->
                    ApiResponse.ok(T2Dto.convertEntityToDto(entity))
                }?:ApiResponse.error("search name not found!!")
            }?:throw IllegalArgumentException("parameter error")


    /**
     *  Embedded Type 조회
     */
    @GetMapping("/s/city")
    fun searchCity(request: HttpServletRequest) : ApiResponse<List<T2Dto>> =
        request.getParameter("city")
            ?.let{
                t2Repository.findByCity(it)?.let{ entitys->
                    val l =  entitys.map {e->T2Dto.convertEntityToDto(e)}
                    ApiResponse.ok(l)
                }?:ApiResponse.error("search city not found!!")
            }?:throw IllegalArgumentException("parameter error")


    /**
     *  조회시 객체타입으로 변환후 반환 sample
     */
    @GetMapping("/s/name2/{name}")
    fun searchName2(@PathVariable("name") name:String , request: HttpServletRequest)
            :ApiResponse<T2Dto> = t2Repository.findByName2(name)?.let {e->
                            ApiResponse.ok(e)
                        }?:ApiResponse.error("search name not found!!")


    @GetMapping("/s/name3")
    fun getNames(request: HttpServletRequest):ApiResponse<List<T2Dto>> =
        t2Repository.findByName3()?.let{
           val r =  it.map { t2 ->T2Dto.convertEntityToDto(t2) }
            ApiResponse.ok(r)
        }?:ApiResponse.error("emplty")


    @GetMapping("/s/lj")
    fun getLeftJoin(request: HttpServletRequest):ApiResponse<List<T2Dto>> =
        t2Repository.findBylj()?.let { l->
            ApiResponse.ok(l.map { t2->T2Dto.convertEntityToDto(t2) })
        }
            ?:ApiResponse.error("empty")
}