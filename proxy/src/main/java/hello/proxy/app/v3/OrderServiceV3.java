package hello.proxy.app.v3;

import org.springframework.stereotype.Service;

/**
 * Project : proxy
 * Package :hello.proxy.app.v3
 * Author :  zinnaworks
 * Date : 08/01/2022
 * Desc :
 */
@Service
public class OrderServiceV3 {

     private final OrderRepositoryV3 orderRepository;
    public OrderServiceV3(OrderRepositoryV3 orderRepository){
        this.orderRepository = orderRepository;
    }
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
