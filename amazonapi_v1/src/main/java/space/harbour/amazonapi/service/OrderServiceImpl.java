package space.harbour.amazonapi.service;

import space.harbour.amazonapi.domain.Order;
import space.harbour.amazonapi.domain.User;
import space.harbour.amazonapi.repository.OrderRepository;
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
