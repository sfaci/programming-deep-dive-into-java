package com.svalero.amazon.service;

import com.svalero.amazon.domain.Product;
import com.svalero.amazon.exception.ProductNotFoundException;
import com.svalero.amazon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findByCategory(String categoryName) {
        List<Product> products = productRepository.findByCategory(categoryName);
        return products;
    }

    @Override
    public void addProduct(Product product) {
        // Aqui podría haber más código
        productRepository.save(product);
    }

    @Override
    public void addProducts(Product... products) {
        for (Product product : products) {
            addProduct(product);
        }
    }
}
