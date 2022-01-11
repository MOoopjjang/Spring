package com.example.advanced.app.v44;

import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.TraceTemplate;
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
public class OrderControllerV44 {

    private final OrderServiceV44 orderService;
    private final LogTrace trace;

    @GetMapping("/v44/request")
    public String request(String itemid) throws Exception{

        TraceTemplate<String> tt = (id)->{
            orderService.orderItem(id );
            return "ok";
        };
        return tt.execute(trace ,"OrderServiceV44.request()" , itemid);
    }
}
