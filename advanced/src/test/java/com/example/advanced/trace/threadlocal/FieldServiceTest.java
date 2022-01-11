package com.example.advanced.trace.threadlocal;

import com.example.advanced.trace.threadlocal.code.FieldService;
import com.example.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Project : advanced
 * Package :com.example.advanced.trace.threadlocal.code
 * Author :  zinnaworks
 * Date : 01/01/2022
 * Desc : 동시성 문제 테스트
 */
@Slf4j
public class FieldServiceTest {

//    private FieldService service = new FieldService();
    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void synctest(){
        log.info("======= start ============");
        Runnable r1 = ()->{
            service.save("r1");
        };

        Runnable r2 = ()->{
            service.save("r2");
        };

        new Thread(r1).start();
        sleep(100);
        new Thread(r2).start();

       sleep(2000);

        log.info("======= end ============");
    }

    private void sleep(long mil){
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
