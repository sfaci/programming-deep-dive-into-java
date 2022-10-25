package com.svalero.myshop.controller;

import com.svalero.myshop.domain.Product;
import com.svalero.myshop.service.ProductService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

/**
 * Controlador para zonas generales de la aplicación
 */
@Controller
public class WebController {

    private final Logger logger = LoggerFactory.getLogger(WebController.class);

    private final ProductService productService;

    public WebController(@NonNull ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    @PostMapping("/")
    public String index(Model model) {
        Set<Product> products = productService.findAllVisible();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        return "checkout";
    }
}
