package hello.proxy.app.v2;

import hello.proxy.app.v1.OrderRepositoryV1;

/**
 * Project : proxy
 * Package :hello.proxy.app.v2
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    public OrderServiceV2(OrderRepositoryV2 orderRepository){
        this.orderRepository = orderRepository;
    }
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
