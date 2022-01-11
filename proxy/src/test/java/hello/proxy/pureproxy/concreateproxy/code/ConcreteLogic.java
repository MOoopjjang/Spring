package hello.proxy.pureproxy.concreateproxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.concreateproxy.code
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Slf4j
public class ConcreteLogic {

    public String operation(){
        log.info("ConcreteLogic 실행");
        return "data";
    }
}
