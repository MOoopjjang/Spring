package com.mooop.m.config

import org.hibernate.dialect.MySQL8Dialect
import org.hibernate.dialect.function.SQLFunctionTemplate
import org.hibernate.type.StandardBasicTypes

class CustomDialect : MySQL8Dialect() {
    init{
        registerFunction("match" , SQLFunctionTemplate(StandardBasicTypes.INTEGER , "match(?1) against (?2 in boolean mode)"))
    }
}