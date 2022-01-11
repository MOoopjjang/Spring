package com.example.advanced.app.v2;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : advanced
 * Package :com.example.advanced.app.v0
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemid){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderControllerV2.request()");
            orderService.orderItem(itemid , status.getTraceId());
            trace.end(status);
            return "ok";
        }catch(Exception e){
            if(status != null){
                trace.excetpion(status , e);
            }
            throw e;
        }

    }
}
