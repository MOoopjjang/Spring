package hello.proxy.pureproxy.decorate;

import hello.proxy.pureproxy.decorate.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.decorate
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
@Slf4j
public class DecoratePatternTest {

    @Test
    void noDecorate(){
        RealComponent component = new RealComponent();
        DecoratePatternClient client = new DecoratePatternClient(component);
        String value = client.execute();
        log.info("value : "+value);
    }

    @Test
    void decorateProxy1(){
        Component component = new RealComponent();
        Component proxy = new MessageDecorator(component);
        DecoratePatternClient client = new DecoratePatternClient(proxy);
        String value = client.execute();
        log.info("value : "+value);
    }

    @Test
    void decorateProxy2(){
        Component component = new RealComponent();
        Component messageDecorator = new MessageDecorator(component);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratePatternClient client = new DecoratePatternClient(timeDecorator);
        String value = client.execute();
        log.info("value : "+value);
    }
}
