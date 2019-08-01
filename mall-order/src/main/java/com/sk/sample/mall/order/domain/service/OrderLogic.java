package com.sk.sample.mall.order.domain.service;

import com.sk.sample.mall.order.application.proxy.feign.AccountProxy;
import com.sk.sample.mall.order.application.proxy.feign.ProductProxy;
import com.sk.sample.mall.order.application.proxy.feign.dto.product.Product;
import com.sk.sample.mall.order.domain.model.Order;
import com.sk.sample.mall.order.domain.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderLogic")
@Slf4j
public class OrderLogic implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductProxy productClient;

    @Autowired
    private AccountProxy accountClient;

    @Override
    public Order purchase(Order order) {

        if (order.getId() == null){
            throw new RuntimeException("Order id is required");
        }

        if (order.getPurchased()){
            throw new RuntimeException("This order is already purchased!");
        }

        if (order.getCreditCard() == null ){
            throw new RuntimeException("Credit Card is required!");
        }

        if (order.getShippingAddress() == null) {
            log.error("Shipping Address is null!. use the default address");

            order.setShippingAddress(accountClient.findAccount(order.getBuyerAccountId()).getAddress());
        }

        Product product = productClient.findProduct(order.getProductId());
        log.debug("Product: {}", product.toString());

        order.setTotalPrice(product.getPrice().getValue() * order.getProductCount());
        log.debug("Order: {}", order.toString());

        order.setPurchased(true);

        return orderRepository.save(order);

    }
}
