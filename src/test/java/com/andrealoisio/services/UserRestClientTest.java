package com.andrealoisio.services;

import com.andrealoisio.jsonobjects.UserJson;
import com.andrealoisio.services.restclients.UserRestClient;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class UserRestClientTest {

    @Inject
    @RestClient
    UserRestClient userRestClient;

    @Test
    void testGetUser() {
        UserJson user = userRestClient.getUser();
        assert true;
    }

    @Test
    void testGetUserByUsername() {
        UserJson user = userRestClient.getUserByUsername("andrealoisio");
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

}