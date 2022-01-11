package com.example.advanced.app.v5;

import com.example.advanced.trace.callback.TraceCallbackTemplate;
import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Project : advanced
 * Package :com.example.advanced.app.v0
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@Repository
public class OrderRepositoryV5 {

    private TraceCallbackTemplate template;

    public OrderRepositoryV5(LogTrace trace){
        this.template = new TraceCallbackTemplate(trace);
    }

    public void save(String itemId){
        // 저장로직...
        template.execute("OrderRepositoryV5.save()" , ()->{
            if(itemId.equals("ex")){
                    throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
             return null;
        });
    }

    private void sleep(int time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){}
    }
}
