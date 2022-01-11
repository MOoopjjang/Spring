package com.example.advanced.trace.template;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.template
 * Author :  zinnaworks
 * Date : 03/01/2022
 * Desc :
 */
public interface TraceTemplate<T> {

    default T execute(LogTrace trace , String message , String itemId) throws Exception{
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = call(itemId);
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status , new IllegalStateException());
            throw e;
        }
    }


    T call(String itemId) throws Exception;
}
