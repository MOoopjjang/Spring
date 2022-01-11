package com.example.advanced.trace.callback;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.callback
 * Author :  zinnaworks
 * Date : 06/01/2022
 * Desc : TemplateCallback pattern
 */
public class TraceCallbackTemplate {

    private final LogTrace trace;

    public TraceCallbackTemplate(LogTrace trace){
        this.trace = trace;
    }


    public <T> T execute(String message , TraceCallback<T> callback){
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = callback.call();
            trace.end(status);
            return result;
        }catch(Exception e){
            trace.exception(status , e);
            throw e;
        }
    }
}
