package com.andrealoisio.services;

import com.andrealoisio.entity.Repository;
import com.andrealoisio.repositories.RepositoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RepositoryService {
    @Inject
    RepositoryRepository repositoryRepository;

    public List<Repository> getAllRepositories() {
        return repositoryRepository.findAll().list();
    }
}
