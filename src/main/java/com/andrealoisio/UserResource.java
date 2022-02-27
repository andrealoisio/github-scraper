package com.andrealoisio;

import com.andrealoisio.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser() {
        userService.getUser();
        return "ok user";
    }
}
