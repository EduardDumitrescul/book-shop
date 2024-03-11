package org.example.data.repositories;

import org.example.data.models.User;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {
    IUserRepository userRepository = UserRepository.getInstance();

    @Test
    public void checkUsernameExists() {
        User user = new User("new user", "new pass");
        userRepository.insert(user);
        assertTrue(userRepository.usernameExists(user.getUsername()));
    }

}