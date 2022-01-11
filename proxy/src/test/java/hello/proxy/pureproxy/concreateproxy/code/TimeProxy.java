package hello.proxy.pureproxy.concreateproxy.code;

import lombok.extern.slf4j.Slf4j;

import java.util.Currency;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.concreateproxy.code
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Slf4j
public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic target;
    public TimeProxy(ConcreteLogic target){
        this.target = target;
    }

    @Override
    public String operation(){
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();
        String result = target.operation();
        long consumeTime = System.currentTimeMillis() - startTime;
        log.info("TimeDecorator 종료 time={} ms" ,consumeTime);
        return result;
    }
}
