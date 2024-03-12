package org.example.data.repositories;

import org.example.data.models.User;

public interface IUserRepository {
    boolean usernameExists(String username);

    void insert(User user);

}
