package com.svalero.myshop.service;

import com.svalero.myshop.domain.User;

import java.util.Set;

/**
 * Service para gestión de usuarios
 */
public interface UserService {

    boolean add(User user);
    void remove(User user);
    Set<User> findAll();
    User findByUsername(String username);
    Set<User> findByCity(String city);
}
