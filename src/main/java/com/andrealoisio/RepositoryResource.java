package com.andrealoisio;

import com.andrealoisio.entities.Repository;
import com.andrealoisio.services.RepositoryService;
import com.andrealoisio.services.UserService;
import io.quarkus.runtime.StartupEvent;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/repositories")
public class RepositoryResource {

    @Inject
    RepositoryService repositoryService;

    @Inject
    UserService userService;

    @Inject
    SearchSession searchSession;

    @Transactional
    void onStart(@Observes StartupEvent ev) throws InterruptedException {
        // only reindex if we imported some content
        // if (Respo.count() > 0) {
            searchSession.massIndexer()
                    .startAndWait();
        // }
    }

    @GET
    public Response getAllRepositories() {
        var repositories = repositoryService.getAllRepositories();
        return Response.ok(repositories).build();
    }

    @GET
    @Path("/search")
    @Transactional
    public Response searchRepository(@QueryParam String pattern) {
        var response = searchSession.search(
                Repository.class).where(f -> pattern == null || pattern.trim().isEmpty() ? f.matchAll() : f.simpleQueryString().fields("description").matching(pattern)
        ).fetchHits(20);
        return Response.ok(response).build();
    }


    @GET
    @Path("/user/{username}")
    public Response searchRepositories(@PathParam String username) {
        return userService.getUserRepositories(username);
    }

}
