package com.svalero.amazon.controller;

import com.svalero.amazon.domain.Order;
import com.svalero.amazon.domain.Product;
import com.svalero.amazon.domain.User;
import com.svalero.amazon.exception.ProductNotFoundException;
import com.svalero.amazon.service.OrderService;
import com.svalero.amazon.service.ProductService;
import com.svalero.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("/add-order/{productId}")
    public String addOrder(@PathVariable long productId) throws ProductNotFoundException {
        Product product = productService.findProduct(productId);
        // TODO Cambiar cuando implementemos la parte de seguridad y login de usuarios
        User user = userService.findUser(1);
        orderService.addOrder(product, user);
        return "redirect:/product/" + productId;
    }

    @GetMapping("/my-orders")
    public String getOrders(Model model) {
        // TODO Cambiar cuando implementemos la parte de seguridad y login de usuarios
        User user = userService.findUser(1);
        List<Order> orders =  orderService.findOrders(user);
        model.addAttribute("orders", orders);
        return "my-orders";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleException(HttpServletRequest request, ProductNotFoundException exception) {
        return "product_error";
    }
}
