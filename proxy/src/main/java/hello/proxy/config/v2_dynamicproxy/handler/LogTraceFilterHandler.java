package hello.proxy.config.v2_dynamicproxy.handler;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Project : proxy
 * Package :hello.proxy.config.v2_dynamicproxy.handler
 * Author :  zinnaworks
 * Date : 10/01/2022
 * Desc : 특정조건을 경우에는 log를 trace하지 않는다.
 */
@Slf4j
public class LogTraceFilterHandler implements InvocationHandler {
    private final Object target;
    private final LogTrace logTrace;
    private final String[] patterns;

    public LogTraceFilterHandler(Object target, LogTrace logTrace, String[] patterns){
        this.target = target;
        this.logTrace = logTrace;
        this.patterns = patterns;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //메서도 이름 필터.
        if(!PatternMatchUtils.simpleMatch(patterns , method.getName())){
            return method.invoke(target , args);
        }

        TraceStatus status = null;
        try{
            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName()+"()";
            status = logTrace.begin(message);
            Object result = method.invoke(target , args);
            logTrace.end(status);
            return result;
        }catch(Exception e){
            logTrace.exception(status , e);
            throw e;
        }

    }
}
