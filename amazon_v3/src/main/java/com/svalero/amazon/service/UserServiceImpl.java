package com.svalero.amazon.service;

import com.svalero.amazon.domain.Product;
import com.svalero.amazon.domain.User;
import com.svalero.amazon.exception.ProductNotFoundException;
import com.svalero.amazon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // TODO Modificar cuando se implemente la seguridad
    @Override
    public User findUser(long id) {
        return userRepository.findById(id).get();
    }
}
