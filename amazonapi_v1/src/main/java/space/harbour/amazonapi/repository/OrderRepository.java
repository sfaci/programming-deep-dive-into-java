package space.harbour.amazonapi.repository;

import space.harbour.amazonapi.domain.Order;
import space.harbour.amazonapi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();
    List<Order> findByUser(User user);
}
