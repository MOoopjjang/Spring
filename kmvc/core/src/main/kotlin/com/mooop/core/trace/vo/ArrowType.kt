package com.mooop.core.trace.vo

/**
 * Project : kmvc
 * Package :com.mooop.core.trace.vo
 * Author :  mooop
 * Date : 14/05/2022
 * Desc :
 */
enum class ArrowType constructor(val code:String){
    SPACE("|  "),
    RIGHT("|-->"),
    LEFT("|<--"),
    ERROR("|<X-");
}