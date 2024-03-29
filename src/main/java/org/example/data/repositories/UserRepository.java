package org.example.data.repositories;

import org.example.data.entities.UserEntity;

public interface UserRepository {
    UserEntity getUser(int id);

    boolean usernameExists(String username);

    int add(UserEntity user);

    UserEntity getByUsername(String username);

}
