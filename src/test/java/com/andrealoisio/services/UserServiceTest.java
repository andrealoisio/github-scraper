package com.andrealoisio.services;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
class UserServiceTest {

    @Inject
    UserService userService;

    @Test
    void getAllUsers() {
        var users = userService.getAllUsers();
        System.out.println("Printing users");
        System.out.println(users);
    }

    @Test
    void getUserByUsername() {
    }
}