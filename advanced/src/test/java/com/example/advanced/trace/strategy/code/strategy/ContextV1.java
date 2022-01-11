package com.example.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.strategy.code.strategy
 * Author :  zinnaworks
 * Date : 06/01/2022
 * Desc :
 */
@Slf4j
public class ContextV1 {
    private final IStrategy strategy;

    public ContextV1(IStrategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis() - startTime;
        log.info("#### execute() end  - time : "+endTime+" ms");
    }
}
