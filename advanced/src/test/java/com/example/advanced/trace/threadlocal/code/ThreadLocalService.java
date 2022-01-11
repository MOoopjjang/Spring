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
public class ThreadLocalService {
    private ThreadLocal<String> names = new ThreadLocal<>();


    public void save(String name){
        log.info("저장 : {}" , name);
        names.set(name);

        sleep(1000);
        log.info("===>조회{}<====" , names.get());
    }

    private void sleep(int mil) {

        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
