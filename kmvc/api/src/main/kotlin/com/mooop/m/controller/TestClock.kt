package com.mooop.m.controller

import java.time.Clock
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


/**
 * Project: kmvc
 * Package :com.mooop.m.controller
 * Author : mooopjjang
 * Date 2024/03/12
 * DESC :
 */



fun main(args:Array<String>){
    val clock:Clock = Clock.systemDefaultZone()

    val ldt = LocalDateTime.now(clock)
    val settlementDateTime:LocalDateTime = ldt.with(LocalTime.MIN)

    println("settlementDateTime = ${settlementDateTime}" )

    var now:LocalDateTime = LocalDateTime.now();
    var nextHour:LocalDateTime = now.plusHours(1).withMinute(0).withSecond(0).withNano(0);

    println(" now = ${now}")
    println(" nextHour = ${nextHour}")

    println("===========================================================================")

    var thisMonth1st: LocalDate = LocalDate.of(settlementDateTime.getYear(), settlementDateTime.getMonth(), 1);
    var prevMonth1st:LocalDate = thisMonth1st.minusMonths(1);
    println(" thisMonth1st = ${thisMonth1st}")
    println(" prevMonth1st = ${prevMonth1st}")

    println("===========================================================================")
    val lastDayOfMonth: LocalDate = LocalDate.of(prevMonth1st.getYear(), prevMonth1st.getMonth(), prevMonth1st.lengthOfMonth())
    println(" lastDayOfMonth = ${lastDayOfMonth}")
}