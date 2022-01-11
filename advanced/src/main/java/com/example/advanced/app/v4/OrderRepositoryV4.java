package com.example.advanced.app.v4;

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
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId){
        // 저장로직...

         AbstractTemplate<String> at = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                if(itemId.equals("ex")){
                    throw new IllegalStateException("예외 발생");
                }
                sleep(1000);
                return null;
            }
        };
        at.execute("OrderRepositoryV4.save()");
    }

    private void sleep(int time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){}
    }
}
