package com.mooop.m.team.factory

import com.mooop.m.team.controller.vo.MemberVo
import com.mooop.m.team.repository.entity.Member
import java.util.*

/**
 * Project: kmvc
 * Package :com.mooop.m.factory
 * Author : mooopjjang
 * Date 2024/01/18
 * DESC :
 */
class MemberFactory {

    companion object{

        fun convertMemberEntity(member: MemberVo) : Member =
            Member(
                mid = UUID.randomUUID().toString().replace("-" , ""),
                name = member.name,
                age = member.age
            )
    }

}