package org.example.services;

import org.example.data.entities.UserEntity;
import org.example.data.mappers.UserMapper;
import org.example.data.models.User;
import org.example.data.repositories.UserRepository;

public class AccountService {
    private UserRepository userRepository = UserRepository.getInstance();

    private User currentUser = null;
    private AccountService() {}
    public boolean isUnique(String username) {
        return !userRepository.usernameExists(username);
    }

    public boolean usernameExists(String username) {return userRepository.usernameExists(username); }

    public void register(String username, String password) throws Exception {
        if(isUnique(username)) {
            User user = new User(0, username, password);
            userRepository.add(UserMapper.asEntity(user));
            currentUser = user;
        }
        else {
            throw new Exception("Username is already in use");
        }
    }

    public boolean passwordIsCorrect(String username, String password) {
        UserEntity entity = userRepository.findUserByUsername(username);
        User user = UserMapper.asUser(entity);
        return user.getPassword().equals(password);
    }

    public void login(String username, String password) throws Exception {
        if(!usernameExists(username)) {
            throw new Exception("Username does not exist!");
        }
        if(!passwordIsCorrect(username, password)) {
            throw new Exception("Password is incorrect!");
        }
        UserEntity entity  = userRepository.findUserByUsername(username);
        currentUser = UserMapper.asUser(entity);
    }


    private static AccountService instance = null;
    public static AccountService getInstance() {
        if(instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
