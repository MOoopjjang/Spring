package com.example.advanced.trace.logtrace;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.logtrace
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@Slf4j
public class FieldLogTrace implements LogTrace {

    private final static String START_PREFIX = "--->";
    private final static String END_PREFIX = "<--";
    private final static String EX_PREFIX = "<X-";

    private TraceId traceIdHolder; //traceId 동기화;동시성 이슈 발생

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceIdHolder;
        Long startMs = System.currentTimeMillis();
        log.info("[{}] {}{}" , traceId.getId() , addSpace(START_PREFIX , traceId.getLevel()) , message );
        return new TraceStatus(traceId , startMs , message);
    }

    private void syncTraceId(){
        if(traceIdHolder == null){
            traceIdHolder = new TraceId();
        }else{
            traceIdHolder = traceIdHolder.createNextId();
        }
    }

    @Override
    public void end(TraceStatus status) {
        complete(status , null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
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

        releaseTraceId();
    }

    private void releaseTraceId() {
        if(traceIdHolder.isFirstLevel()){
            traceIdHolder = null;
        }else{
            traceIdHolder = traceIdHolder.createPrevId();
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
