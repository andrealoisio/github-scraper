package com.andrealoisio.services;

import com.andrealoisio.entity.Repository;
import com.andrealoisio.jsonobjects.RepositoryJson;
import com.andrealoisio.repositories.RepositoryRepository;
import com.andrealoisio.services.restclients.RepositoryRestClient;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ScrapeService {

    @RestClient
    RepositoryRestClient repositoryRestClient;

    @Inject
    RepositoryRepository repositoryRepository;

    @Transactional
    public void scrape() {

        Log.info("Scrape started");
        List<RepositoryJson> repositoryList = repositoryRestClient.getRepositories();
        Log.info(repositoryList);

        List<Repository> entityRepositoryList = repositoryList.stream().map(RepositoryJson::toEntity).collect(Collectors.toList());
        Log.info(entityRepositoryList);

        repositoryRepository.persist(entityRepositoryList);

        Log.info(entityRepositoryList);

    }
}
