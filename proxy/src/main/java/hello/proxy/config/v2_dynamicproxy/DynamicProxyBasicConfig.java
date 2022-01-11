package hello.proxy.config.v2_dynamicproxy;

import hello.proxy.app.v1.*;
import hello.proxy.config.v2_dynamicproxy.handler.CacheBasicHandler;
import hello.proxy.config.v2_dynamicproxy.handler.LogTraceBasicHandler;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

/**
 * Project : proxy
 * Package :hello.proxy.config.v2_dynamicproxy
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Configuration
public class DynamicProxyBasicConfig {


    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace){
        OrderControllerV1 target = new OrderControllerV1Impl(orderServiceV1(logTrace));


        /**
         * cache 용도
         */
        CacheBasicHandler cacheBasicHandler = new CacheBasicHandler(target);
         OrderControllerV1 cacheProxy = (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader()
                                ,new Class[]{OrderControllerV1.class}
                                ,cacheBasicHandler);


        /**
         * trace 용도
         */
        LogTraceBasicHandler handler = new LogTraceBasicHandler(cacheProxy , logTrace);
        OrderControllerV1 logProxy = (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader()
                                ,new Class[]{OrderControllerV1.class}
                                ,handler);


        return logProxy;
    }


    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderServiceV1 target = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
        LogTraceBasicHandler handler = new LogTraceBasicHandler(target , logTrace);
        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader()
                        ,new Class[]{OrderServiceV1.class}
                        ,handler);
        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace){
        OrderRepositoryV1 target = new OrderRepositoryV1Impl();
        LogTraceBasicHandler handler = new LogTraceBasicHandler(target , logTrace);
        OrderRepositoryV1 proxy = (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader()
            ,new Class[]{OrderRepositoryV1.class}
            ,handler);
        return proxy;
    }





}
