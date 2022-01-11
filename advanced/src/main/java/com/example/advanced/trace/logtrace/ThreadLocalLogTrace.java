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
public class ThreadLocalLogTrace implements LogTrace{
    private final static String START_PREFIX = "--->";
    private final static String END_PREFIX = "<--";
    private final static String EX_PREFIX = "<X-";

    /** 동시성 문제 해결 ... */
    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceIdHolder.get();
        Long startMs = System.currentTimeMillis();
        log.info("[{}] {}{}" , traceId.getId() , addSpace(START_PREFIX , traceId.getLevel()) , message );
        return new TraceStatus(traceId , startMs , message);
    }

    private void syncTraceId(){
        if(traceIdHolder.get() == null ){
            traceIdHolder.set(new TraceId());
        }else{
            TraceId traceId = traceIdHolder.get().createNextId();
            traceIdHolder.set(traceId);
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
        if(traceIdHolder.get().isFirstLevel()){
            traceIdHolder.remove();
        }else{
            TraceId traceId = traceIdHolder.get().createPrevId();
            traceIdHolder.set(traceId);
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
