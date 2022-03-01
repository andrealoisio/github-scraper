package com.andrealoisio;

import com.andrealoisio.entity.Repository;
import com.andrealoisio.services.RepositoryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/repositories")
public class RepositoryResource {

    @Inject
    RepositoryService repositoryService;

    @GET
    public List<Repository> getAllRepositories() {
        return repositoryService.getAllRepositories();
    }
}
