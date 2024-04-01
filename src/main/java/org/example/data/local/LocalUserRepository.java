package org.example.data.local;

import org.example.data.entities.UserEntity;
import org.example.data.repositories.UserRepository;

import java.util.SortedMap;
import java.util.TreeMap;

public class LocalUserRepository implements UserRepository {
    private static LocalUserRepository instance = null;
    private static int idCount = 0;
    private final SortedMap<String, UserEntity> users = new TreeMap<>();

    private LocalUserRepository() {}


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


    public UserEntity getByUsername(String username) {
        if(users.containsKey(username)) {
            return users.get(username);
        }
        return null;
    }

    public void generateId(UserEntity user) {
        idCount ++;
        user.setId(idCount);
    }

    public static LocalUserRepository getInstance() {
        if(instance == null) {
            instance = new LocalUserRepository();
        }
        return instance;
    }
}
