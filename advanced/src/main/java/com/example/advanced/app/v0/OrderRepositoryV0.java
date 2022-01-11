package com.example.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Project : advanced
 * Package :com.example.advanced.app.v0
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc :
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId){
        // 저장로직...
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생");
        }
        sleep(1000);
    }

    private void sleep(int time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){}
    }
}
