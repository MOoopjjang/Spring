package com.mooop.m.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QuerydslConfig constructor(
    @PersistenceContext
    private val entityManager:EntityManager
) {

    @Bean
    fun jpaQueryFactory():JPAQueryFactory{
        return JPAQueryFactory(this.entityManager)
    }
}