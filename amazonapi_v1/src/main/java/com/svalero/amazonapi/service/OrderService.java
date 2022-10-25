package com.svalero.amazonapi.service;

import com.svalero.amazonapi.domain.Order;
import com.svalero.amazonapi.domain.Product;
import com.svalero.amazonapi.domain.User;

import java.util.List;

public interface OrderService {

    List<Order> findOrders(User user);
}
