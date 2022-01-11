package com.example.advanced.trace.logtrace;

import com.example.advanced.trace.TraceStatus;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.logtrace
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status , Exception e);
}
