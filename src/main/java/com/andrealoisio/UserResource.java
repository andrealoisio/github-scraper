package com.andrealoisio;

import com.andrealoisio.entities.User;
import com.andrealoisio.services.UserService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public Response getAllUsers() {
        var users = userService.getAllUsers();
        return Response.ok(users).build();
    }

    @GET
    @Path("/{username}")
    public Response getUserByUsername(@PathParam String username) {
        var user = userService.getUserByUsername(username);
        return Response.ok(user).build();
    }

    @GET
    @Path("/{username}/repositories")
    public Response getUserRepositories(@PathParam String username) {
        var user = userService.getUserByUsername(username);
        return Response.ok(user).build();
    }

}
