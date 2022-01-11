package com.example.advanced.app.v44;

import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.TraceTemplate;
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
public class OrderServiceV44 {

    private final OrderRepositoryV44 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) throws Exception{
        TraceTemplate<String> tt = (id)->{
              orderRepository.save(id);
              return null;
        };
        tt.execute(trace , "OrderServiceV44.orderItem()" , itemId);
    }
}
