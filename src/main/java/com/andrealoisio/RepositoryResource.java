package com.andrealoisio;

import com.andrealoisio.services.RepositoryService;
import com.andrealoisio.services.UserService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


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
        return userService.getUserRepositories(username);
    }

}
