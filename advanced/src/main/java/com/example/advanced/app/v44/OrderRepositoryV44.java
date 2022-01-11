package com.example.advanced.app.v44;

import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.TraceTemplate;
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
public class OrderRepositoryV44  {

    private final LogTrace trace;

    public void save(String itemId) throws Exception{
        // 저장로직...

        TraceTemplate<String> tt = (id)->{
            if(id.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
          return null;
        };
        tt.execute(trace , "OrderRepositoryV44.save()" , itemId);
    }

    private void sleep(int time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){}
    }

}
