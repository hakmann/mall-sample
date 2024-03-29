package com.sk.sample.mall.product.domain.model;

import com.sk.sample.mall.shared.base.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@Embeddable
public class ProductDescription implements ValueObject {
    //
    @Enumerated(EnumType.STRING)
    private ColorType colorType;

    @Enumerated(EnumType.STRING)
    private SizeType sizeType;

    public ProductDescription(ColorType colorType, SizeType sizeType) {
        this.colorType = colorType;
        this.sizeType = sizeType;
    }
}
