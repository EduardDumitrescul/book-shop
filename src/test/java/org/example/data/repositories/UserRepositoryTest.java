package org.example.data.repositories;

import org.example.data.entities.UserEntity;
import org.example.data.local.LocalUserRepository;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {
    LocalUserRepository userRepository = LocalUserRepository.getInstance();

    @Test
    public void checkUsernameExists() {
        UserEntity entity = new UserEntity(0, "new user", "new pass", 1);
        userRepository.add(entity);
        assertTrue(userRepository.usernameExists(entity.username));
    }

}