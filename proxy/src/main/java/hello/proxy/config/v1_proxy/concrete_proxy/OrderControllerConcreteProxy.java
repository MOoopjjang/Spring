package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.config.v1_proxy.concrete_proxy
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc :
 */
@Slf4j
public class OrderControllerConcreteProxy extends OrderControllerV2 {
    private final OrderControllerV2 target;
    private final LogTrace trace;


    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }

    @Override
    public String request(String itemId) {
         TraceStatus status = null;
        try{
            status = trace.begin("OrderController.request()");
            String result = target.request(itemId);
            trace.end(status);
            return result;
        }catch(Exception e){
            trace.exception(status , e);
            throw e;
        }
    }
}
