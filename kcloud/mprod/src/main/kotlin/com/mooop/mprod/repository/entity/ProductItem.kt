package com.mooop.mprod.repository.entity

data class ProductItem constructor(
    val id:Long,
    val itemName:String,
    val itemPrice:Int,
    var itemComment:String?
)
