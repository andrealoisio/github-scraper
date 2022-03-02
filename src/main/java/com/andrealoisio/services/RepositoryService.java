package com.andrealoisio.services;

import com.andrealoisio.entities.Repository;
import com.andrealoisio.repositories.RepositoryRepository;
import com.andrealoisio.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RepositoryService {
    @Inject
    RepositoryRepository repositoryRepository;

    @Inject
    UserRepository userRepository;

    public List<Repository> getAllRepositories() {
        return repositoryRepository.findAll().list();
    }

    public List<Repository> getRepositoriesByUser(String user) {
        var storedUser = userRepository.findByUsername(user);
        return repositoryRepository.findByUserId(storedUser.getUserId());
    }
}
