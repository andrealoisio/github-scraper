package com.andrealoisio.services;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
class RepositoryServiceTest {

    @Inject
    RepositoryService repositoryService;

    @Test
    @Transactional
    void getAllRepositories() {

        var repos = repositoryService.getAllRepositories();
        System.out.println("Printing repositories");
        System.out.println(repos.size());
        System.out.println(repos);
    }
}