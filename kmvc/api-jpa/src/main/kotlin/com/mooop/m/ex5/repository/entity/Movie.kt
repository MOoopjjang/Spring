package com.mooop.m.ex5.repository.entity

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@DiscriminatorValue("M")
@Table(name = "TST_EX5_MOVIE")
class Movie constructor(

        @Column(name = "DIRECTOR")
        var director:String?=null,

        @Column(name = "ACTOR")
        var actor:String?=null
) : Ex5Item()