package com.mooop.m.app.query

import com.mooop.m.infra.db.entity.AccessHistoryData

interface AccessInfoServiceQueryInterface {

    fun getUserAccessInformation(userId:String):List<AccessHistoryData>?
}