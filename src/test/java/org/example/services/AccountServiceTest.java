package org.example.services;

import org.example.data.Seeder;
import org.example.data.entities.UserEntity;
import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private UserRepository userRepository = UserRepository.getInstance();
    private AccountService accountService = AccountService.getInstance();

    private String mockUsername = "account service test username";
    private String mockPassword = "account service test password";

    @BeforeEach
    public void setUp() {
        Seeder.seed();
    }

    @Test
    void isUnique() {
        UserEntity user = new UserEntity(1, "John", "Pass", 1);

        assertTrue(accountService.isUnique(user.username));
        userRepository.add(user);
        assertFalse(accountService.isUnique(user.username));
    }

    @Test
    void register(){
        String username = "register";
        String password = "pass";
        assertDoesNotThrow(() -> accountService.register(username, password));
        assertThrows(Exception.class, () -> accountService.register(username, password));

    }

    @Test
    void login() {
        UserEntity user = new UserEntity(0, "login", "login", 1);
        assertThrows(Exception.class, () -> accountService.login(user.username, user.password));
        userRepository.add(user);
        assertDoesNotThrow(() -> accountService.login(user.username, user.password));
        assertTrue(accountService.isLoggedIn());
    }

    @Test
    void userLoggedAfterRegister() {
        assertDoesNotThrow(() -> accountService.register(mockUsername, mockPassword));
        assertTrue(accountService.isLoggedIn());
    }

    @Test
    void getUserTest() {
        User user = accountService.getUserById(1);
        System.out.println(user.toString());
    }
}