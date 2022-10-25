package space.harbour.amazonapi.service;

import space.harbour.amazonapi.domain.Order;
import space.harbour.amazonapi.domain.User;

import java.util.List;

public interface OrderService {

    List<Order> findOrders(User user);
}
