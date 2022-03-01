package com.andrealoisio.services.restclients;

import com.andrealoisio.jsonobjects.RepositoryJson;
import com.andrealoisio.services.RestClientHeaderFactory;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.util.List;

@Path("/repositories")
@RegisterRestClient(configKey = "github-api")
@RegisterClientHeaders(RestClientHeaderFactory.class)
public interface RepositoryRestClient {

    @GET
    List<RepositoryJson> getRepositoriesSince(@QueryParam() Long since);

    @GET
    List<RepositoryJson> getRepositories();

}
