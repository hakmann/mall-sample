package com.sk.sample.mall.order;

import com.sk.sample.mall.order.domain.model.CreaditCard;
import com.sk.sample.mall.order.domain.model.Order;
import com.sk.sample.mall.order.domain.repository.OrderRepository;
import com.sk.sample.mall.order.domain.service.OrderService;
import com.sk.sample.mall.shared.domain.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestClass implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... strings) throws Exception {
        // create new orders
        Order order = new Order(1L, 1L, 3);

        // set additional info
        order.setCreditCard(new CreaditCard("113-33-2", "2022-02-22"));
        //order.setShippingAddress(new Address(11123, "Seoul"));
        Order persistedOrder = orderRepository.save(order);
        log.debug(persistedOrder.toString());
        orderService.purchase(persistedOrder);

    }
}
