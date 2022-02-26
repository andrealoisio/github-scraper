package com.andrealoisio.service;

import com.andrealoisio.domain.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users")
@RegisterRestClient(configKey = "users-api")
public interface UserRestClient {

    @GET
    @Path("/andrealoisio")
    User getUser();

    @GET
    @Path("/{username}")
    User getUserByUsername(@PathParam String username);

}
