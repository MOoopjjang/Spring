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
public class StrategyLogic2 implements IStrategy{
    @Override
    public void call() {
        log.info("StrategyLogic2 -> call()");
    }
}
