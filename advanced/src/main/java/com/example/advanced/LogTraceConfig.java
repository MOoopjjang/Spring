package com.example.advanced;

import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : advanced
 * Package :com.example.advanced
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@Configuration
public class LogTraceConfig {

//    @Bean  --> V3
//    public LogTrace logTrace(){
//        return new FieldLogTrace();
//    }

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
