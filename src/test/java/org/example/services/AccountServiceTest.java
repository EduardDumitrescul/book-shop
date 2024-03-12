package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.IUserRepository;
import org.example.data.repositories.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private IUserRepository userRepository = UserRepository.getInstance();
    private AccountService accountService = AccountService.getInstance();

    private String mockUsername = "account service test username";
    private String mockPassword = "account service test password";

    @Test
    void isUnique() {
        User user = new User("John", "Pass");

        assertTrue(accountService.isUnique(user.getUsername()));
        userRepository.insert(user);
        assertFalse(accountService.isUnique(user.getUsername()));
    }

    @Test
    void register(){
        String username = "register";
        String password = "pass";
        assertDoesNotThrow(() -> accountService.register(username, password));
        assertThrows(Exception.class, () -> accountService.register(username, password));

    }

    @Test
    void userLoggedAfterRegister() {
        assertDoesNotThrow(() -> accountService.register(mockUsername, mockPassword));
        assertTrue(accountService.isLoggedIn());
    }
}