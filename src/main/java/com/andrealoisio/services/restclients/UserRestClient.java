package com.andrealoisio.services.restclients;

import com.andrealoisio.jsonobjects.UserJson;
import com.andrealoisio.services.RestClientHeaderFactory;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users")
@RegisterRestClient(configKey = "github-api")
@RegisterClientHeaders(RestClientHeaderFactory.class)
public interface UserRestClient {

    @GET
    @Path("/{username}")
    UserJson getUserByUsername(@PathParam String username);

}
