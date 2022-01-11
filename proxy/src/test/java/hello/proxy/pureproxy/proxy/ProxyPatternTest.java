package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

/**
 * Project : proxy
 * Package :hello.proxy.pureproxy.proxy
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
public class ProxyPatternTest {

    @Test
    void noProxyTest(){
        RealSubject subject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest(){
        CacheProxy subject = new CacheProxy(new RealSubject());
        ProxyPatternClient client = new ProxyPatternClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }
}
