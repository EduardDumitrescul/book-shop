package org.example.data.repositories;

import org.example.data.entities.UserEntity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class UserRepository {
    private static UserRepository instance = null;
    private static int idCount = 0;
    private SortedMap<String, UserEntity> users = new TreeMap<>();

    private UserRepository() {}


    public UserEntity getUser(int id) {
        for(UserEntity entity: users.values()) {
            if(entity.id == id) {
                return entity.clone();
            }
        }
        return null;
    }

    public boolean usernameExists(String username) {
        return users.containsKey(username);
    }


    public int add(UserEntity user) {
        generateId(user);
        users.put(user.username, user);
        return user.id;
    }


    public UserEntity findUserByUsername(String username) {
        if(users.containsKey(username)) {
            return users.get(username);
        }
        return null;
    }

    public void generateId(UserEntity user) {
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
