package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.AImpl;
import hello.proxy.jdkdynamic.code.AInterface;
import hello.proxy.jdkdynamic.code.TimeInvocationHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * Project : proxy
 * Package :hello.proxy.jdkdynamic
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Slf4j
public class JdkDynamicTest {

    @Test
    void dynamicA(){
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader()
            ,new Class[]{AInterface.class}
            ,handler);

        proxy.call();
        log.info("target : {}" , target.getClass());
        log.info("proxy : {}" , proxy.getClass());
    }
}
