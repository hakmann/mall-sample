package com.sk.sample.mall.order.domain.model;

import com.sk.sample.mall.shared.base.AbstractEntity;
import com.sk.sample.mall.shared.base.AggregateRoot;
import com.sk.sample.mall.shared.domain.Address;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "order_tab")
public class Order extends AbstractEntity implements AggregateRoot {
    //
    private Long buyerAccountId;

    private Long productId;
    private Integer productCount;

    private CreaditCard creditCard;
    private Address shippingAddress;
    private Integer totalPrice;
    private Boolean purchased = false;

    public Order(Long buyerAccountId, Long productId, Integer productCount) {
        this.buyerAccountId = buyerAccountId;
        this.productId = productId;
        this.productCount = productCount;
    }
}
