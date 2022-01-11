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
public class RealComponent implements Component{
    @Override
    public String operation() {
        log.info("RealComponent 호출");
        return "data";
    }
}
