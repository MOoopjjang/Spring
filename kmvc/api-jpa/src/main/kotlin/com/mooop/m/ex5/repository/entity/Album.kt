package com.mooop.m.ex5.repository.entity

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@DiscriminatorValue("A")
@Table(name = "TST_EX5_ALBUM")
class Album constructor(
        @Column(name = "ARTIST")
        var artist:String?=null
) : Ex5Item()