package com.example.advanced.trace.hellotrace;

import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.hellotrace
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
public class HelloTraceV1Test {

    @Test
    void begin_end(){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus status = traceV1.begin("hello");
        traceV1.end(status);
    }

    @Test
    void begin_ex(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.excetpion(status , new IllegalStateException());
    }
}
