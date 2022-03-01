package com.andrealoisio;

import com.andrealoisio.entity.User;
import com.andrealoisio.services.UserService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("/{username}")
    public List<User> getAllUsers(@PathParam String username) {
        return userService.getUserByUsername(username);
    }

}
