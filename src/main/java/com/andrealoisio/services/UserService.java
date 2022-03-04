package com.andrealoisio.services;

import com.andrealoisio.entities.Repository;
import com.andrealoisio.entities.User;
import com.andrealoisio.repositories.RepositoryRepository;
import com.andrealoisio.repositories.UserRepository;
import com.andrealoisio.rest.client.UserRestClient;
import io.quarkus.panache.common.Page;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    RepositoryService repositoryService;

    static final int MAX_PAGE_SIZE = 25;

    public List<User> getAllUsers() {
        return userRepository.findAll().page(Page.ofSize(MAX_PAGE_SIZE)).list();
    }

    public Response getUserByUsername(String username) {
        return userRepository
                .find("login", username)
                .singleResultOptional()
                .map(user -> Response.ok(user).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public Response getUserRepositories(String username) {
        return userRepository
                .find("login", username)
                .singleResultOptional()
                .map(user -> Response.ok(repositoryService.getRepositoriesByUser(user.getLogin())).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public List<User> findUsersByIds(List<Long> ids) {
        return userRepository.findUsersByIds(ids);
    }

}
