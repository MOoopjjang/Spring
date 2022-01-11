package com.example.advanced.app.v5;

import com.example.advanced.trace.callback.TraceCallbackTemplate;
import com.example.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : advanced
 * Package :com.example.advanced.app.v0
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc : TemplateCallback Pattern
 */
@RestController
public class OrderControllerV5 {

    private  OrderServiceV5 orderService;
    private TraceCallbackTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService , LogTrace trace){
        this.orderService = orderService;
        this.template = new TraceCallbackTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemid){
        return template.execute("OrderControllerV5.request()" , ()->{
            orderService.orderItem(itemid );
            return "ok";
        });
    }
}
