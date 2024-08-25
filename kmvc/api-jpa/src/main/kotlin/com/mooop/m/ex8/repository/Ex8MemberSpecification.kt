package com.mooop.m.ex8.repository

import com.mooop.m.ex8.repository.entity.Ex8Member
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

/**
 * Project: kmvc
 * Package :com.mooop.m.ex8.repository
 * Author : mooopjjang
 * Date 2024/03/11
 * DESC : 동적쿼리 테스트
 */
class Ex8MemberSpecification {

    companion object{
        fun likeName(name:String): Specification<Ex8Member>{
            return object : Specification<Ex8Member> {
                override fun toPredicate(
                    root: Root<Ex8Member>,
                    query: CriteriaQuery<*>,
                    criteriaBuilder: CriteriaBuilder
                ): Predicate? {
                    return criteriaBuilder.like(root.get("name") , "%" + name + "%")
                }

            }
        }

        fun betweenAge(startAge:Int , endAge:Int):Specification<Ex8Member>{
            return object: Specification<Ex8Member>{
                override fun toPredicate(
                    root: Root<Ex8Member>,
                    query: CriteriaQuery<*>,
                    criteriaBuilder: CriteriaBuilder
                ): Predicate? {
                    return criteriaBuilder.between(root.get("age") , startAge , endAge)
                }

            }
        }
    }
}