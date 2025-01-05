package com.mooop.et.resource

import com.mooop.et.domain.EvtTaskManager
import com.mooop.et.domain.dto.Person
import com.mooop.et.domain.enums.EventActionType
import com.mooop.et.domain.model.EventJobModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/event-task")
class EventTaskResource constructor(
    val evtTaskManager:EvtTaskManager
){



    @GetMapping("/t1")
    fun t1():ResponseEntity<String> {
        mutableListOf(
            EventJobModel<Person>(1,EventActionType.READ , Person("cwkim" , 1 , "incheon"))
            ,EventJobModel<Person>(1,EventActionType.UNKNOWN , Person("bhkim" , 11 , "buchon"))
            ,EventJobModel<Person>(1,EventActionType.WRITE , Person("khlee" , 30 , "aaaa"))
        )  .forEach { ejm->
            evtTaskManager.execute(ejm)
        }
        return ResponseEntity.ok().body("SUCCESS")
    }
}