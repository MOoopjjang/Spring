package com.example.advanced.app.v1;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.hellotrace.HelloTraceV1;
import com.example.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Project : advanced
 * Package :com.example.advanced.app.v0
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
     private final HelloTraceV1 trace;

    public void orderItem(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderServiceV1.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        }catch(Exception e){
            if(status != null){
                trace.excetpion(status , e);
            }
            throw e;
        }


    }
}
