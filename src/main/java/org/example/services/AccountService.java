package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.IUserRepository;
import org.example.data.repositories.UserRepository;

public class AccountService {
    private IUserRepository userRepository = UserRepository.getInstance();

    private User currentUser = null;
    private AccountService() {}
    public boolean isUnique(String username) {
        return !userRepository.usernameExists(username);
    }

    public boolean usernameExists(String username) {return userRepository.usernameExists(username); }

    public void register(String username, String password) throws Exception {
        if(isUnique(username)) {
            User user = new User(username, password);
            userRepository.insert(user);
            currentUser = user;
        }
        else {
            throw new Exception("Username is already in use");
        }
    }

    public boolean passwordIsCorrect(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        return user.getPassword().equals(password);
    }

    public void login(String username, String password) throws Exception {
        if(!usernameExists(username)) {
            throw new Exception("Username does not exist!");
        }
        if(!passwordIsCorrect(username, password)) {
            throw new Exception("Password is incorrect!");
        }
        currentUser = userRepository.findUserByUsername(username);
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
