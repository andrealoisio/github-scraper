package com.andrealoisio;

import com.andrealoisio.entities.Repository;
import com.andrealoisio.repositories.UserRepository;
import com.andrealoisio.services.RepositoryService;
import com.andrealoisio.services.UserService;
import io.quarkus.logging.Log;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.core.Response;
import java.util.List;

@Path("/repositories")
public class RepositoryResource {

    @Inject
    RepositoryService repositoryService;

    @Inject
    UserService userService;

    @GET
    public Response getAllRepositories() {
        var repositories = repositoryService.getAllRepositories();
        return Response.ok(repositories).build();
    }

    @GET
    @Path("/user/{username}")
    public Response searchRepositories(@PathParam String username) {
        var user = userService.getUserRepositories(username);
        return Response.ok(user).build();
    }

}
