package com.andrealoisio.services;

import com.andrealoisio.repositories.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ScrapeServiceTest {

    @Inject
    UserRepository userRepository;

    @Test
    void testInClause() {
        var users = userRepository.findByUserId(List.of(93694596l, 100047450l));
        System.out.println(users);
    }

}