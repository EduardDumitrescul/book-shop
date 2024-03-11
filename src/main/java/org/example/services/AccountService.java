package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.IUserRepository;
import org.example.data.repositories.UserRepository;

public class AccountService {
    private IUserRepository userRepository = UserRepository.getInstance();
    private AccountService() {}
    public boolean isUnique(String username) {
        return !userRepository.usernameExists(username);
    }

    public void register(String username, String password) throws Exception {

        if(isUnique(username)) {
            User user = new User(username, password);
            userRepository.insert(user);
        }
        else {
            throw new Exception("Username is already in use");
        }
    }


    private static AccountService instance = null;
    public static AccountService getInstance() {
        if(instance == null) {
            instance = new AccountService();
        }
        return instance;
    }
}
