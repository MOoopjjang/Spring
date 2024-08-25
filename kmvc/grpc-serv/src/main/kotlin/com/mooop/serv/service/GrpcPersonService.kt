package com.mooop.serv.service

import com.mooop.grpc.lib.MOoopGrpc
import com.mooop.grpc.lib.PersonRequest
import com.mooop.grpc.lib.PersonResponse
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.slf4j.LoggerFactory

@GrpcService
class GrpcPersonService : MOoopGrpc.MOoopImplBase(){

    val LOGGER = LoggerFactory.getLogger(GrpcPersonService::class.java)

    override fun getPersonInfo(request: PersonRequest?, responseObserver: StreamObserver<PersonResponse>?) {
        LOGGER.info(">>> gerPersonInfo() Called!!!")

        val response = PersonResponse.newBuilder()
            .setUserId("aaaaaaaa")
            .setName("cwkim")
            .setAge(20)
            .setAddr("Incheon")
            .build()

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()

    }
}