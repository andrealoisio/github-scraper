package com.andrealoisio.service;

import com.andrealoisio.domain.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users/andrealoisio")
@RegisterRestClient(configKey = "users-api")
public interface UserRestClient {

    @GET
    User getUser();

}
