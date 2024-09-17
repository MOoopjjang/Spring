package com.mooop.mprod.handler.dto

data class ProductItemRes constructor(
    val result:String,
    val id:Long,
    val itemName:String,
    val itemPrice:Int,
    var itemComment:String?

)
