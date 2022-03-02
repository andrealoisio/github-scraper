package com.andrealoisio.rest.client;

import com.andrealoisio.rest.jsonobjects.RepositoryJson;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.util.List;

@Path("/repositories")
@ApplicationScoped
@RegisterRestClient(configKey = "github-api")
@RegisterClientHeaders(RestClientHeaderFactory.class)
public interface RepositoryRestClient {

    @GET
    List<RepositoryJson> getRepositoriesSince(@QueryParam() Long since);

}
