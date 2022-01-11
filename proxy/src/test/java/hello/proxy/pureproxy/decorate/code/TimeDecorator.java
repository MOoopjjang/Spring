package hello.proxy.pureproxy.decorate.code;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.decorate.code
 * Author :  zinnaworks
 * Date : 09/01/2022
 * Desc :
 */
@Slf4j
public class TimeDecorator implements Component{
    private Component component;
    public TimeDecorator(Component component){
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();
        String result = component.operation();
        long endTime = System.currentTimeMillis() - startTime;
        log.info("TimeDecorator 종료 resultTime = {}ms" , endTime);
        return result;
    }
}
