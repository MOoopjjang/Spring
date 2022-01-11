package com.example.advanced.app.v3;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;
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
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemid){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderServiceV3.request()");
            orderService.orderItem(itemid );
            trace.end(status);
            return "ok";
        }catch(Exception e){
            if(status != null){
                trace.exception(status , e);
            }
            throw e;
        }

    }
}
