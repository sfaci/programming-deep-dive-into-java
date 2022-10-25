package com.svalero.amazon.service;

import com.svalero.amazon.domain.Order;
import com.svalero.amazon.domain.Product;
import com.svalero.amazon.domain.User;
import com.svalero.amazon.repository.OrderRepository;
import com.svalero.amazon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addOrder(Product product, User user) {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setQuantity(1);
        order.setProduct(product);
        order.setUser(user);
        orderRepository.save(order);
    }

    @Override
    public List<Order> findOrders(User user) {
        // Listar los productos de un usuario determinado
        return orderRepository.findByUser(user);
    }
}
