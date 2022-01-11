package hello.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Project : proxy
 * Package :hello.proxy.cglib.code
 * Author :  zinnaworks
 * Date : 11/01/2022
 * Desc :
 */
@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
        Object result = methodProxy.invoke(target , args);
//        Object result = method.invoke(target , args);
        log.info("TimeProxy 종료 time = {} ms" , System.currentTimeMillis() - startTime);
        return result;
    }
}
