package com.example.advanced.app.v5;

import com.example.advanced.trace.callback.TraceCallbackTemplate;
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
public class OrderServiceV5 {

    private  OrderRepositoryV5 orderRepository;
    private TraceCallbackTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository , LogTrace trace){
        this.orderRepository = orderRepository;
        this.template = new TraceCallbackTemplate(trace);
    }

    public void orderItem(String itemId){
        template.execute("OrderServiceV5.orderItem()" , ()->{
            orderRepository.save(itemId);
            return null;
        });
    }
}
