package com.andrealoisio.services;

import com.andrealoisio.entity.Repository;
import com.andrealoisio.repositories.RepositoryRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

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