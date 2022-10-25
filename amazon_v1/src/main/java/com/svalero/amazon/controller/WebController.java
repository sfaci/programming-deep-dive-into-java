package com.svalero.amazon.controller;

import com.svalero.amazon.domain.Product;
import com.svalero.amazon.exception.ProductNotFoundException;
import com.svalero.amazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);
        return "index";
    }

    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);
        return "catalog";
    }

    @RequestMapping(value = "/product/{id}")
    public String product(Model model, @PathVariable long id) throws ProductNotFoundException {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        return "product";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleException(HttpServletRequest request, ProductNotFoundException exception) {
        return "product_error";
    }

    @ExceptionHandler
    public String handleException(HttpServletRequest request, Exception exception) {
        return "error";
    }
}
