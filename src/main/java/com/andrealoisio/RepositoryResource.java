package com.andrealoisio;

import com.andrealoisio.entities.Repository;
import com.andrealoisio.services.RepositoryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/repositories")
public class RepositoryResource {

    @Inject
    RepositoryService repositoryService;

    @GET
    public Response getAllRepositories() {
        var repositories = repositoryService.getAllRepositories();
        return Response.ok(repositories).build();
    }
}
