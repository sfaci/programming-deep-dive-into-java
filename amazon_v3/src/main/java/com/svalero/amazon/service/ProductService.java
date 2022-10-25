package com.svalero.amazon.service;

import com.svalero.amazon.domain.Product;
import com.svalero.amazon.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();
    Product findProduct(long id) throws ProductNotFoundException;
    List<Product> findByCategory(String categoryName);

    void addProduct(Product product);
    void addProducts(Product... products);
}
