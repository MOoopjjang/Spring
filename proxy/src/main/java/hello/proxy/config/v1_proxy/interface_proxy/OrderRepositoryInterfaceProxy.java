package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderRepositoryV1;
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
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {
    private final OrderRepositoryV1 target;
    private final LogTrace trace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepository.save()");
            target.save(itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status , e);
            throw e;
        }

    }
}
