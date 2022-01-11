package hello.proxy.pureproxy.decorate.code;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.decorate.code
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
@Slf4j
public class MessageDecorator implements Component{
    private Component component;
    public MessageDecorator(Component component){
        this.component = component;
    }
    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String result = component.operation();
        String decorateResult = "******"+ result + "******";
        return decorateResult;
    }
}
