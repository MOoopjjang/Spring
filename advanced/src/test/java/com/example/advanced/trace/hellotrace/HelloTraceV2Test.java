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
public class HelloTraceV2Test {

    @Test
    void begin_end(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync("hello2" , status1.getTraceId());
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_ex(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync("hello2" , status1.getTraceId());
        trace.excetpion(status2 , new IllegalStateException());
        trace.excetpion(status1 , new IllegalStateException());
    }
}
