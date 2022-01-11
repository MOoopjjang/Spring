package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Project : proxy
 * Package :hello.proxy.common.service
 * Author :  zinnaworks
 * Date : 11/01/2022
 * Desc :
 */
@Slf4j
public class ServiceImpl implements ServiceInterface{
    @Override
    public void save() {
        log.info("save 호출");
    }

    @Override
    public void find() {
        log.info("find 호출");
    }
}
