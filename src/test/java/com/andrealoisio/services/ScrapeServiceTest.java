package com.andrealoisio.services;

import com.andrealoisio.repositories.UserRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

@QuarkusTest
class ScrapeServiceTest {

    @Inject
    UserService userService;

    @Inject
    ScrapeService scrapeService;

    @Test
    @TestTransaction
    void testScrapeService() {
        scrapeService.scrape();

        var user1 = userService.getUserByUsername("johndoe0000000001");
        Assertions.assertNotNull(user1);

        var user2 = userService.getUserByUsername("johndoe0000000002");
        Assertions.assertNotNull(user2);

        var repos = userService.getUserRepositories("johndoe0000000001");
        Assertions.assertTrue(((List)repos.getEntity()).size() > 0);

    }

    @Test
    void testInClause() {
        var users = userService.findUsersByIds(List.of(93694596l, 100047450l));
        Assertions.assertTrue(users.size() > 0);
    }

}