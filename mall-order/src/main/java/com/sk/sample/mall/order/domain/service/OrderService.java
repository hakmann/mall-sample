package com.sk.sample.mall.order.domain.service;

import com.sk.sample.mall.order.domain.model.Order;

public interface OrderService {
    Order purchase(Order order);
}
