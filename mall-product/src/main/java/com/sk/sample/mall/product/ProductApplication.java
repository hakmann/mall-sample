package com.sk.sample.mall.product;

import com.sk.sample.mall.product.domain.model.*;
import com.sk.sample.mall.product.domain.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class ProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(ProductRepository productRepository) {
		return (args) -> {
			// 1
			insertProduct(productRepository);
			System.out.println("Initial Insert --------------");
			displayAll(productRepository);

			System.out.println("Update IronMan's price");
			// 2
			updatePriceByName(productRepository, "Iron Man", 25000);
			displayByName(productRepository,"Iron Man");

			// 3
			System.out.println("333333333");
			findBySize(productRepository, SizeType.M);

			// 4
			System.out.println("4444444444");
			findByColor(productRepository, ColorType.BLUE);

			// 5
			System.out.println("555555555");
			findByPriceEqualAndGreaterThan(productRepository, new Money(17000));

			// 6
			System.out.println("666666666");
			findByPriceEqualAndLessThan(productRepository, new Money(21000));

			// 7
			System.out.println("7777777777");
			findByPriceBetween(productRepository, new Money(10000), new Money(20000));
		};
	}

	public void insertProduct(ProductRepository productRepository){
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

	public void displayAll(ProductRepository productRepository){
		productRepository.findAll().forEach(product -> {
			System.out.println(product.toString());
		});
	}

	public void displayByName(ProductRepository productRepository, String name){
		System.out.println(productRepository.findDistinctByName(name).toString());
	}

	public void findBySize(ProductRepository productRepository, SizeType sizeType){
		productRepository.findAll(QProduct.product.productDescription.sizeType.eq(sizeType)).forEach(product -> {
			System.out.println(product.toString());
		});
    }

    public void findByColor(ProductRepository productRepository, ColorType colorType){
		productRepository.findAll(QProduct.product.productDescription.colorType.eq(colorType)).forEach(product -> {
			System.out.println(product.toString());
		});
	}

	public void findByPriceEqualAndGreaterThan(ProductRepository productRepository, Money money){
		productRepository.findAll(QProduct.product.price.value.goe(money.getValue())).forEach(product -> {
			System.out.println(product.toString());
		});
	}

	public void findByPriceEqualAndLessThan(ProductRepository productRepository, Money money){
		productRepository.findAll(QProduct.product.price.value.loe(money.getValue())).forEach(product -> {
			System.out.println(product.toString());
		});
	}

	public void findByPriceBetween(ProductRepository productRepository, Money money1, Money money2) {
		productRepository.findAll(QProduct.product.price.value.gt(money1.getValue())
									.and(QProduct.product.price.value.lt(money2.getValue()))).forEach(product -> {
			System.out.println(product.toString());
		});
	}
}
