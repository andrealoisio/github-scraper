package com.andrealoisio.services;

import com.andrealoisio.entity.User;
import com.andrealoisio.repositories.UserRepository;
import com.andrealoisio.services.restclients.UserRestClient;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @RestClient
    UserRestClient userRestClient;

    @Inject
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll().list();
    }

    public List<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
