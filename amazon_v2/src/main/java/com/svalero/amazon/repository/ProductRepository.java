package com.svalero.amazon.repository;

import com.svalero.amazon.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();
    Product findByName(String name);
    Product findByPrice(double price);
    List<Product> findByCategory(String category);
}
