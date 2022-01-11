package com.example.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.threadlocal.code
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@Slf4j
public class FieldService {
    private String name;


    public void save(String name){
        this.name = name;

        sleep(1000);
        log.info("===>{}<====" , this.name);
    }

    private void sleep(int mil) {

        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
