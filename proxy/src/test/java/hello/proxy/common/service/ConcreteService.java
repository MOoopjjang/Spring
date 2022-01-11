package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.common.service
 * Author :  zinnaworks
 * Date : 11/01/2022
 * Desc :
 */
@Slf4j
public class ConcreteService {

    public void call(){
        log.info("ConcreteService 호출");
    }
}
