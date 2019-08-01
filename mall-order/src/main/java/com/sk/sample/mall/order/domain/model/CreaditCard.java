package com.sk.sample.mall.order.domain.model;

import com.sk.sample.mall.shared.base.ValueObject;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class CreaditCard implements ValueObject {
    private String cardNumber;
    private String validThru;

    public CreaditCard(String cardNumber, String validThru) {
        this.cardNumber = cardNumber;
        this.validThru = validThru;
    }
}
