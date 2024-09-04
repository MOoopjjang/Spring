package com.mooop.order.repository.entity

data class OrderEntity constructor(
    val id:Long,
    val cd:String,
    val name:String,
    val price:Int,
    val qty:Int
)
