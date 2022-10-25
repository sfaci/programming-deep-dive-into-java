package com.svalero.amazon.repository;

import com.svalero.amazon.domain.Order;
import com.svalero.amazon.domain.Product;
import com.svalero.amazon.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();
    List<Order> findByUser(User user);
}
