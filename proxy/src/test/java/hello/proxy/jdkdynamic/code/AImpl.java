package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.jdkdynamic.code
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Slf4j
public class AImpl implements AInterface{
    @Override
    public String call() {
        log.info("A 호출");
        return "a";
    }
}
