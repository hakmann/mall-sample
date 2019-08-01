package com.sk.sample.mall.order.domain.repository;

import com.sk.sample.mall.order.domain.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
