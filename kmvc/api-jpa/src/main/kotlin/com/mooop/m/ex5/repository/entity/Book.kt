package com.mooop.m.ex5.repository.entity

import javax.persistence.*

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")  //ID 재정의
@Table(name = "TST_EX5_BOOK")
class Book constructor(
        @Column(name = "AUTHOR")
        var author:String?=null,

        @Column(name = "ISBN")
        var isbn:String?=null
) : Ex5Item()