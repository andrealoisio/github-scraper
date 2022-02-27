package com.andrealoisio.services;

import com.andrealoisio.repositories.UserRepository;
import com.andrealoisio.services.restclients.UserRestClient;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @RestClient
    UserRestClient userRestClient;

    @Inject
    UserRepository userRepository;

    @Transactional
    public void getUser() {
        var user = userRestClient.getUser();
        var userEntity = user.toEntity();

        Log.info(user);
        Log.info(userEntity);
        userRepository.persist(userEntity);

        // userEntity.persist();
        Log.info(userEntity);
    }
}
