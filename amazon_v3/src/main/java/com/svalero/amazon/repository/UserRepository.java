package com.svalero.amazon.repository;

import com.svalero.amazon.domain.Order;
import com.svalero.amazon.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    User findByUsername(String username);
}
