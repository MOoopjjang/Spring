package com.example.advanced.trace.hellotrace;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.hellotrace
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */

@Slf4j
@Component
public class HelloTraceV2 {

    private final static String START_PREFIX = "--->";
    private final static String END_PREFIX = "<--";
    private final static String EX_PREFIX = "<X-";

    public TraceStatus begin(String message){
        TraceId traceId = new TraceId();
        Long startMs = System.currentTimeMillis();
        log.info("[{}] {}{}" , traceId.getId() , addSpace(START_PREFIX , traceId.getLevel()) , message );
        return new TraceStatus(traceId , startMs , message);
    }

    //V2에서 추가
    public TraceStatus beginSync(String message , TraceId beforeTraceId){
        TraceId nTraceId = beforeTraceId.createNextId();
        Long startMs = System.currentTimeMillis();
        log.info("[{}] {}{}" , nTraceId.getId() , addSpace(START_PREFIX , nTraceId.getLevel()) , message );
        return new TraceStatus(nTraceId , startMs , message);
    }



    public void end(TraceStatus status){
        complete(status , null);
    }

    public void excetpion(TraceStatus status , Exception e){
        complete(status , e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if(e == null){
            log.info("[{}] {}{} time={}ms" , traceId.getId() , addSpace(END_PREFIX , traceId.getLevel()) , status.getMessage() , resultTimeMs);
        }else{
            log.info("[{}] {}{} time={}ms ex={}" , traceId.getId() , addSpace(EX_PREFIX , traceId.getLevel()) , status.getMessage() , resultTimeMs , e.toString());
        }
    }


    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < level ; i++){
            sb.append((i == level-1)?"|"+prefix:"|      ");
        }
        return sb.toString();
    }
}
