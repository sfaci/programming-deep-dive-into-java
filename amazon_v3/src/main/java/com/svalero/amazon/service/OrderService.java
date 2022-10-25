package com.svalero.amazon.service;

import com.svalero.amazon.domain.Order;
import com.svalero.amazon.domain.Product;
import com.svalero.amazon.domain.User;

import java.util.List;

public interface OrderService {

    void addOrder(Product product, User user);
    List<Order> findOrders(User user);
}
