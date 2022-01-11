package com.example.advanced.app.v4;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.AbstractTemplate;
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
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){
        AbstractTemplate<String> at = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        at.execute("OrderServiceV4.orderItem()");
    }
}
