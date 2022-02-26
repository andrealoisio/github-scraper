package com.andrealoisio.service;

import com.andrealoisio.domain.User;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserRestClientTest {

    @Inject
    @RestClient
    UserRestClient userRestClient;

    @Test
    void testGetUser() {
        User user = userRestClient.getUser();
        assert true;
    }

    @Test
    void testGetUserByUsername() {
        User user = userRestClient.getUserByUsername("andrealoisio");
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

}