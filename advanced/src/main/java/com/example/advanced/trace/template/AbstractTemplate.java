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
abstract public class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message){
         TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = call();
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status , new IllegalStateException());
            throw e;
        }
    }

    protected abstract T call();
}
