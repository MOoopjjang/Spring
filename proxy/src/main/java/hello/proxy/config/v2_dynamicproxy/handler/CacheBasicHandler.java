package hello.proxy.config.v2_dynamicproxy.handler;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Project : proxy
 * Package :hello.proxy.config.v2_dynamicproxy.handler
 * Author :  zinnaworks
 * Date : 11/01/2022
 * Desc :
 */
@Slf4j
public class CacheBasicHandler implements InvocationHandler {

    private final Object target;
    private Object value;
    public CacheBasicHandler(Object target) {
        this.target = target;
        this.value = null;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Cache Proxy 호출");
        if(this.value == null){
            value =  method.invoke(target , args);
        }
        log.info("Cache Proxy 종료");
        return value;
    }
}
