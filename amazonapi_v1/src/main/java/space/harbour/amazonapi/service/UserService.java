package space.harbour.amazonapi.service;

import space.harbour.amazonapi.domain.User;
import space.harbour.amazonapi.exception.UserNotFoundException;

public interface UserService {

    User addUser(User user);
    User findUser(long id) throws UserNotFoundException;
}
