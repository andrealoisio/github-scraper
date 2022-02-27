package com.andrealoisio.services;

import com.andrealoisio.jsonobjects.RepositoryJson;
import com.andrealoisio.services.restclients.RepositoryRestClient;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ScrapeService {

    @RestClient
    RepositoryRestClient repositoryRestClient;

    public void scrape() {

        Log.info("Scrape started");
        List<RepositoryJson> repositoryList = repositoryRestClient.getRepositories();
        Log.info(repositoryList);

    }
}
