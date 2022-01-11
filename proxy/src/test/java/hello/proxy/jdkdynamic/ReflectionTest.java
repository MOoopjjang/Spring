package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Project : proxy
 * Package :hello.proxy.jdkdynamic
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Slf4j
public class ReflectionTest {

    @Test
    void reflection0(){
        Hello target = new Hello();
        log.info("start");
        String result1 = target.callA();
        log.info("result1 = {}" , result1);


        log.info("start");
        String result2 = target.callB();
        log.info("result2 = {}" , result2);
    }

    @Test
    void reflection2(){

        try {
            Class cls = Class.forName(Hello.class.getName());
            Object target = cls.getDeclaredConstructor().newInstance();
            Method method = cls.getDeclaredMethod("callB");
            String result = (String) method.invoke(target);
            log.info("reflection2() - result : {}" , result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Slf4j
    static class Hello{
        public String callA(){
            log.info("callA");
            return "a";
        }

        public String callB(){
            log.info("callB");
            return "b";
        }
    }
}
