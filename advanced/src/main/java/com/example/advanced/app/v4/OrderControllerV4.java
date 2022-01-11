package com.example.advanced.app.v4;

import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : advanced
 * Package :com.example.advanced.app.v0
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc : TemplateMethod Pattern
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemid){

        AbstractTemplate<String> at = new AbstractTemplate<String>(trace){

            @Override
            protected String call() {
                orderService.orderItem(itemid );
                return "ok";
            }
        };
        return at.execute("OrderControllerV4.request()");
    }
}
