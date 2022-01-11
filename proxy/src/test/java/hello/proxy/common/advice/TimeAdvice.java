package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Project : proxy
 * Package :hello.proxy.common.advice
 * Author :  zinnaworks
 * Date : 11/01/2022
 * Desc :
 */
@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
         log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
//        Object result = method.invoke(target , args);
        Object result = invocation.proceed();
        log.info("TimeProxy 종료 time = {} ms" , System.currentTimeMillis() - startTime);
        return result;
    }
}
