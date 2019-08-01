package com.sk.sample.mall.product;

import com.sk.sample.mall.product.domain.model.*;
import com.sk.sample.mall.product.domain.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestClass implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... strings) throws Exception {
        // 1
        insertProduct();
        log.debug("Initial Insert --------------");
        displayAll();

        log.debug("Update IronMan's price");
        // 2
        updatePriceByName(productRepository, "Iron Man", 25000);
        displayByName("Iron Man");

        // 3
        log.debug("333333333");
        findBySize(SizeType.M);

        // 4
        log.debug("4444444444");
        findByColor(ColorType.BLUE);

        // 5
        log.debug("555555555");
        findByPriceEqualAndGreaterThan(new Money(17000));

        // 6
        log.debug("666666666");
        findByPriceEqualAndLessThan(new Money(21000));

        // 7
        log.debug("7777777777");
        findByPriceBetween(new Money(10000), new Money(20000));
    }

    public void insertProduct(){
        productRepository.save(new Product("Iron Man", new Money(30000), new ProductDescription(ColorType.RED, SizeType.L)));
        productRepository.save(new Product("Captain America", new Money(20000), new ProductDescription(ColorType.BLUE, SizeType.M)));
        productRepository.save(new Product("Winter Soldeir", new Money(15000), new ProductDescription(ColorType.WHITE, SizeType.M)));
    }

    // update
    public void updatePriceByName(ProductRepository productRepository, String name, Integer price){
        Product distinctByName = productRepository.findDistinctByName(name);
        distinctByName.setPrice(new Money(price));
        productRepository.save(distinctByName);
    }

    public void displayAll(){
        productRepository.findAll().forEach(product ->
                log.debug(product.toString())
        );
    }

    public void displayByName(String name){
        log.debug(productRepository.findDistinctByName(name).toString());
    }

    public void findBySize(SizeType sizeType){
        productRepository.findAll(QProduct.product.productDescription.sizeType.eq(sizeType)).forEach(product ->
                log.debug(product.toString())
        );
    }

    public void findByColor(ColorType colorType){
        productRepository.findAll(QProduct.product.productDescription.colorType.eq(colorType)).forEach(product ->
                log.debug(product.toString())
        );
    }

    public void findByPriceEqualAndGreaterThan(Money money){
        productRepository.findAll(QProduct.product.price.value.goe(money.getValue())).forEach(product -> {
            log.debug(product.toString());
        });
    }

    public void findByPriceEqualAndLessThan(Money money){
        productRepository.findAll(QProduct.product.price.value.loe(money.getValue())).forEach(product ->
                log.debug(product.toString())
        );
    }

    public void findByPriceBetween(Money money1, Money money2) {
        productRepository.findAll(QProduct.product.price.value.gt(money1.getValue())
                .and(QProduct.product.price.value.lt(money2.getValue()))).forEach(product ->
                log.debug(product.toString())
        );
    }
}
