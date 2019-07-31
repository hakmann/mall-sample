package com.sk.sample.mall.product.domain.model;

import com.sk.sample.mall.shared.base.AbstractEntity;
import com.sk.sample.mall.shared.base.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Product extends AbstractEntity implements AggregateRoot {
    //
    private String name;
    private Money price;

    private ProductDescription productDescription;

    public Product(String name, Money price, ProductDescription productDescription) {
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
    }
}
