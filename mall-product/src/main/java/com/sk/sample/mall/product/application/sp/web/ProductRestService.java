package com.sk.sample.mall.product.application.sp.web;

import com.sk.sample.mall.product.domain.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductRestService {
    @GetMapping("products/{id}")
    Product findProduct(@PathVariable("id") Long id);

    @GetMapping("products")
    List<Product> findAllProducts();

    @GetMapping("products/size")
    List<Product> findAllProducts(@RequestParam("size") int size);

    @GetMapping("products/search/findByName")
    Product findProduct(@RequestParam(value="name", required=true) String name);
}
