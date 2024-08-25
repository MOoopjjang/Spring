package com.mooop.m.ex6.repository

import com.mooop.m.ex6.repository.entity.Ex6Member
import org.springframework.data.jpa.repository.JpaRepository

interface Ex6MemberRepository : JpaRepository<Ex6Member, Long> {



}