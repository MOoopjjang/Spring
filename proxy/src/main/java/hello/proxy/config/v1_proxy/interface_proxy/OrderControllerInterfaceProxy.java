package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderControllerV1;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

/**
 * Project : proxy
 * Package :hello.proxy.config.v1_proxy.interface_proxy
 * Author :  zinnaworks
 * Date : 09/01/2022
 * Desc :
 */
@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {
    private final OrderControllerV1 target;
    private final LogTrace trace;

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

    @Override
    public String noLog() {
        return target.noLog();
    }
}
