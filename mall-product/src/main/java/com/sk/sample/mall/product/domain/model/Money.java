package com.sk.sample.mall.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Builder
@Embeddable
public class Money {
    private Integer value;

    public Money(Integer value){
        this.value = value;
    }
}
