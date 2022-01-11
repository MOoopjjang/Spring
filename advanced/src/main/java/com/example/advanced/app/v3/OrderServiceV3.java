package com.example.advanced.app.v3;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;
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
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepositoryV3.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        }catch(Exception e){
            if(status != null){
                trace.exception(status , e);
            }
            throw e;
        }


    }
}
