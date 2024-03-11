package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.IUserRepository;
import org.example.data.repositories.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountServiceTest {
    private IUserRepository userRepository = UserRepository.getInstance();
    private AccountService accountService = AccountService.getInstance();
    @Test
    void isUnique() {
        User user = new User("John", "Pass");

        assertTrue(accountService.isUnique(user.getUsername()));
        userRepository.insert(user);
        assertFalse(accountService.isUnique(user.getUsername()));
    }
}