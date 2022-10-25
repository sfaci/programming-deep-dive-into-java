package com.svalero.amazon.service;

import com.svalero.amazon.domain.User;

public interface UserService {

    User addUser(User user);
    User findUser(long id);
}
