package org.example.data.repositories;

import org.example.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static UserRepository instance = null;
    private static int idCount = 0;
    private ArrayList <User> users = new ArrayList<>(List.of(
        new User("default user", "defaultpass"),
        new User("owner", "ownerpass")
    ));

    private UserRepository() {}

    @Override
    public boolean usernameExists(String username) {
        for(User user: users) {
            if(user.getUsername() == username) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void insert(User user) {
        generateId(user);
        users.add(user);
    }

    public void generateId(User user) {
        idCount ++;
        user.setId(idCount);
    }

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
}
