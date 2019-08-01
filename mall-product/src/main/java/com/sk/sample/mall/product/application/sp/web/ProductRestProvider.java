package com.sk.sample.mall.product.application.sp.web;

import com.sk.sample.mall.product.domain.model.Product;
import com.sk.sample.mall.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/")
public class ProductRestProvider implements ProductRestService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    @GetMapping("products/{id}")
    public Product findProduct(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    @GetMapping("products")
    public List<Product> findAllProducts() {
        List<Product> productLists = new ArrayList<>();
        productRepository.findAll().forEach(product -> productLists.add(product));
        return productLists;
    }

    @Override
    @GetMapping("products/size")
    public List<Product> findAllProducts(int size) {
        List<Product> productLists = new ArrayList<>();
        productRepository.findAll().forEach(product -> productLists.add(product));

        List<Product> productSubLists = new ArrayList<>();
        for(int i = 0; i < size; i++){
            productSubLists.add(productLists.get(i));
        }

        return productSubLists;
    }

    @Override
    @GetMapping("products/search/findByName")
    public Product findProduct(String name) {
        return productRepository.findDistinctByName(name);
    }
}
