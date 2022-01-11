package com.example.advanced.trace.logtrace;

import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.logtrace
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
public class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2(){
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_ex_level2(){
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2 , new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}
