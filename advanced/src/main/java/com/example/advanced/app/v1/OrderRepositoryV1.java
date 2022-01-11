package com.example.advanced.app.v1;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.hellotrace.HelloTraceV1;
import com.example.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Project : advanced
 * Package :com.example.advanced.app.v0
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    public void save(String itemId){
        // 저장로직...

        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepositoryV1.save()");
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            trace.end(status);
        }catch(Exception e){
            if(status != null){
                trace.excetpion(status , e);
            }
            throw e;
        }



    }

    private void sleep(int time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){}
    }
}
