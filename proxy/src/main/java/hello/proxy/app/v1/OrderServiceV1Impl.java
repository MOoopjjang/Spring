package hello.proxy.app.v1;

import lombok.RequiredArgsConstructor;

/**
 * Project : proxy
 * Package :hello.proxy.app.v1
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
public class OrderServiceV1Impl implements OrderServiceV1{
    private final OrderRepositoryV1 orderRepository;
    public OrderServiceV1Impl(OrderRepositoryV1 orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
