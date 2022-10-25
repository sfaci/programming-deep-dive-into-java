package space.harbour.amazonapi.controller;

import space.harbour.amazonapi.domain.Product;
import space.harbour.amazonapi.dto.ErrorResponse;
import space.harbour.amazonapi.exception.ProductNotFoundException;
import space.harbour.amazonapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add a product
    @PostMapping(value = "/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // Delete a product
    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) throws ProductNotFoundException {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Edit a product (full modification)
    @PutMapping(value = "/product/{productId}")
    public ResponseEntity<Product> modifyProduct(@PathVariable long productId, @RequestBody Product product) throws ProductNotFoundException {
        Product newProduct = productService.modifyProduct(productId, product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    // Get all products (with or without some filters)
    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(defaultValue = "0") float price,
                                     @RequestParam(defaultValue = "") String category) {
        List<Product> products = null;

        if ((price != 0) && (category.equals(""))) {
            products = productService.findByPrice(price);
        } else {
            products = productService.findAllProducts();
        }

        return ResponseEntity.ok(products);
    }

    // Get a specific product
    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable long productId) throws ProductNotFoundException {
        Product product = productService.findProduct(productId);
        return ResponseEntity.ok(product);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductNotFoundException pnfe) {
        ErrorResponse errorResponse = new ErrorResponse(101, pnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(999, "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}