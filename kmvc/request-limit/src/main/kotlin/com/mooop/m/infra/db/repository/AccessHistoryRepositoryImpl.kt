package com.mooop.m.infra.db.repository

import com.mooop.m.infra.db.entity.AccessHistoryData
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class AccessHistoryRepositoryImpl{

    /** 저장소 */
    private val repository:MutableList<AccessHistoryData> by lazy { mutableListOf() }

    fun save(data: AccessHistoryData) : Boolean  {
        repository.add(data)
        return true
    }
    fun findAll() : List<AccessHistoryData> = Collections.unmodifiableList(repository)
    fun countAll():Int = repository.count()
    fun findByUserId(userId:String) : List<AccessHistoryData>  = repository.filter { data->data.userId == userId }
    fun findByUserIdAndUrl(userId:String, url:String):List<AccessHistoryData> = repository.filter { data->
        data.userId == userId && data.url == url
    }
}