package com.sk.sample.mall.order.application.sp.web;

import com.sk.sample.mall.order.domain.model.Order;
import org.springframework.web.bind.annotation.GetMapping;

public interface OrderRestService {

    @GetMapping("order/purchase")
    void purchase(Order order);
}
