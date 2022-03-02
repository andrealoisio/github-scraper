package com.andrealoisio.rest.client;

import com.andrealoisio.rest.jsonobjects.UserJson;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users")
@ApplicationScoped
@RegisterRestClient(configKey = "github-api")
@RegisterClientHeaders(RestClientHeaderFactory.class)
public interface UserRestClient {

    @GET
    @Path("/{username}")
    UserJson getUserByUsername(@PathParam String username);

}
