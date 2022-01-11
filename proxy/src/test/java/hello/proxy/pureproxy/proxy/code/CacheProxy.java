package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.proxy.code
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
@Slf4j
public class CacheProxy implements Subject{
    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target){
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("proxy 호출");
        if(cacheValue == null){
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}
