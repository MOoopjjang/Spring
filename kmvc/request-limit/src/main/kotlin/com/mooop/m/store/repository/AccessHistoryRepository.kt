package com.mooop.m.store.repository

import com.mooop.m.store.entity.AccessHistoryData
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class AccessHistoryRepository {

    /** 저장소 */
    private val repository:MutableList<AccessHistoryData> by lazy { mutableListOf() }

    fun save(data:AccessHistoryData) = repository.add(data)
    fun findAll() : List<AccessHistoryData> = Collections.unmodifiableList(repository)
    fun countAll():Int = repository.count()
    fun findByUserId(userId:String) : List<AccessHistoryData>  = repository.filter { data->data.userId == userId }
    fun findByUserIdAndUrl(userId:String , url:String):List<AccessHistoryData> = repository.filter { data->
        data.userId == userId && data.url == url
    }
}