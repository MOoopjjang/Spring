package com.mooop.cli.service

import com.mooop.cli.dto.Person
import com.mooop.grpc.lib.MOoopGrpc
import com.mooop.grpc.lib.PersonRequest
import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.stereotype.Service

@Service
class GrpcPersonService {

    @GrpcClient("person")
    lateinit var mooopBlockingStub:MOoopGrpc.MOoopBlockingStub

    fun info(userId:String) : Person =
        try{
            mooopBlockingStub.getPersonInfo(
                PersonRequest.newBuilder()
                    .setUserId("aaaaaaa")
                    .build()
            ).let {
                Person(it.userId , it.name , it.age , it.addr)
            }
        }catch (e:Exception){
            e.printStackTrace()
            throw e
        }


}