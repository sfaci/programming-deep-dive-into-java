package space.harbour.amazonapi.service;

import space.harbour.amazonapi.domain.User;
import space.harbour.amazonapi.exception.UserNotFoundException;
import space.harbour.amazonapi.repository.UserRepository;
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

    // TODO Implement property if security is configured
    @Override
    public User findUser(long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
