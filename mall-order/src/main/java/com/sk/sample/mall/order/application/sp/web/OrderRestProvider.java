package com.sk.sample.mall.order.application.sp.web;

import com.sk.sample.mall.order.domain.model.Order;
import com.sk.sample.mall.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class OrderRestProvider implements OrderService {

    @Autowired
    private OrderService orderService;

    @Override
    @PutMapping("order/purchase")
    public Order purchase(@RequestBody Order order) {
        return orderService.purchase(order);
    }
}
