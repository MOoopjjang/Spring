package hello.proxy.pureproxy.concreateproxy;

import hello.proxy.pureproxy.concreateproxy.code.ConcreteClient;
import hello.proxy.pureproxy.concreateproxy.code.ConcreteLogic;
import hello.proxy.pureproxy.concreateproxy.code.TimeProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.concreateproxy
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Slf4j
public class ConcretProxyTest {

    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void timeProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteLogic timeProxy = new TimeProxy(concreteLogic);
         ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
