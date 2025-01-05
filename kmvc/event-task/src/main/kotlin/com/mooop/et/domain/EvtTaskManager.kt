package com.mooop.et.domain

import com.mooop.et.domain.dto.Person
import com.mooop.et.domain.impl.TaskFailExecutor
import com.mooop.et.domain.impl.TaskPendingExecutor
import com.mooop.et.domain.impl.TaskRunExecutor
import com.mooop.et.domain.model.EventJobModel
import com.mooop.et.domain.model.EventResModel
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
class EvtTaskManager {

    /** worker type */
    enum class WorkerType{
        PENDING,
        RUNNER,
        FAILED
    }

    /** worker mapper */
    private val workerMapper:Map<WorkerType , BasicTaskExecutor<Person>>  = mutableMapOf(
        WorkerType.PENDING to TaskPendingExecutor()
        ,WorkerType.RUNNER to TaskRunExecutor()
        ,WorkerType.FAILED to TaskFailExecutor()
    )

    @PostConstruct
    fun init(){
        workerMapper.forEach { _,v->
            v.execute()
        }
    }

    /**
     * job 실행
     */
    fun execute(job:EventJobModel<Person>):EventResModel{
        val pendingWorker = workerMapper.get(WorkerType.PENDING) as TaskPendingExecutor
        /** valid job */
        pendingWorker.doTransfer { job->
            val runningWorker = workerMapper.get(WorkerType.RUNNER) as TaskRunExecutor
            runningWorker.doFail { job->
                val failedWorker = workerMapper.get(WorkerType.FAILED) as TaskFailExecutor
                failedWorker.add(job)
            }
            runningWorker.add(job)
        }
        /** invalid job */
        pendingWorker.doFail { job->
            val failedWorker = workerMapper.get(WorkerType.FAILED) as TaskFailExecutor
            failedWorker.add(job)
        }
        pendingWorker.add(job)


        return EventResModel("SUCCESS","")
    }
}