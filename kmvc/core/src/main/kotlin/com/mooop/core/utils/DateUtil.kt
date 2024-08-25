package com.mooop.core.utils

import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Project : kmvc
 * Package :com.mooop.core.utils
 * Author :  zinnaworks
 * Date : 16/04/2022
 * Desc :
 */
object DateUtil {

    /**
     * convert LocalDateTime To Date
     */
    fun convertLocalDateTimeToDate(ldt: LocalDateTime):Date = Timestamp.valueOf(ldt)


    /**
     * convert LocalDateTime to format String
     */
    fun convertDateTimeToString(ldt:LocalDateTime , fmt:String):String =
        DateTimeFormatter.ofPattern(fmt).format(ldt)

    /**
     * convert LocalDateTime to format String
     */
    fun convertDateTimeToString(ldt:LocalDateTime):String = convertDateTimeToString(ldt , "YYYY-MM-dd HH:mm:ss.SSS")
}