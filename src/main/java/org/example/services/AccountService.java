package org.example.services;

import org.example.data.repositories.IUserRepository;
import org.example.data.repositories.UserRepository;

public class AccountService {
    private IUserRepository userRepository = UserRepository.getInstance();
    private AccountService() {}
    public boolean isUnique(String username) {
        return !userRepository.usernameExists(username);
    }


    private static AccountService instance = null;
    public static AccountService getInstance() {
        if(instance == null) {
            instance = new AccountService();
        }
        return instance;
    }
}
