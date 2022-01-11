package com.example.advanced.trace.strategy.code;

import com.example.advanced.trace.strategy.code.strategy.ContextV1;
import com.example.advanced.trace.strategy.code.strategy.StrategyLogic1;
import org.junit.jupiter.api.Test;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.strategy.code.strategy
 * Author :  zinnaworks
 * Date : 06/01/2022
 * Desc :
 */
public class ContextV1Test {

    @Test
    void strategyV1(){
        ContextV1 context = new ContextV1(new StrategyLogic1());
        context.execute();

    }

    @Test
    void strategyV2(){
        ContextV1 context1 = new ContextV1(()->{
            System.out.println("call1");
        });

         ContextV1 context2 = new ContextV1(()->{
            System.out.println("call2");
        });

         context1.execute();
         context2.execute();
    }
}
