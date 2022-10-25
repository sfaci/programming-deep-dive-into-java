package com.svalero.amazonapi.service;

import com.svalero.amazonapi.domain.Order;
import com.svalero.amazonapi.domain.User;
import com.svalero.amazonapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findOrders(User user) {
        return orderRepository.findByUser(user);
    }
}
