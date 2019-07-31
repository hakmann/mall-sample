package com.sk.sample.mall.product.domain.repository;

import com.querydsl.core.types.Predicate;
import com.sk.sample.mall.product.domain.model.Product;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, QueryDslPredicateExecutor<Product> {
    //

    List<Product> findAll(Predicate predicate);
    Product findDistinctByName(@Param("name") String name);
}
