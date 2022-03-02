package com.andrealoisio.services;

import com.andrealoisio.entities.Repository;
import com.andrealoisio.entities.User;
import com.andrealoisio.repositories.RepositoryRepository;
import com.andrealoisio.repositories.UserRepository;
import com.andrealoisio.rest.client.UserRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    RepositoryRepository repositoryRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll().list();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<Repository> getUserRepositories(String username) {
        var user = userRepository.findByUsername(username);
        return repositoryRepository.findByUserId(user.getUserId());
    }

}
