package com.andrealoisio.services;

import com.andrealoisio.entity.Repository;
import com.andrealoisio.jsonobjects.RepositoryJson;
import com.andrealoisio.repositories.RepositoryRepository;
import com.andrealoisio.repositories.ScraperInfoRepository;
import com.andrealoisio.services.restclients.RepositoryRestClient;
import com.google.common.collect.Lists;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.config.inject.ConfigProperty;
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

    @Inject
    ScraperInfoRepository scraperInfoRepository;

    @ConfigProperty(name = "scraper.repository.repos-to-persist")
    Integer numberOfReposToPersist;

    @ConfigProperty(name = "scraper.repository.start-id")
    Long repositoryStartId;

    public void scrape() {
        Log.info("Scrape started");

        var repositoryList = repositoryRestClient.getRepositoriesSince(getRepositoryStartId());

        var entityRepositoryList = repositoryList.stream().map(RepositoryJson::toEntity).collect(Collectors.toList());

        var chunks = Lists.partition(entityRepositoryList, numberOfReposToPersist);

        for (List<Repository> chunk : chunks) {
            persistChunk(chunk);
        }

        Log.info("Scrape finished");
    }

    @Transactional
    void persistChunk(List<Repository> repositoryList) {
        repositoryRepository.persist(repositoryList);
        var lastRepo = repositoryList.get(repositoryList.size() - 1);
        var scraperInfo = scraperInfoRepository.findById(1l);
        scraperInfo.setLastRepoId(lastRepo.getRepositoryIdId());
        scraperInfoRepository.persist(scraperInfo);
    }

    private Long getRepositoryStartId() {
        var scraperInfo = scraperInfoRepository.findById(1l);
        if (scraperInfo.getLastRepoId() > 0) {
            return scraperInfo.getLastRepoId();
        }
        return repositoryStartId;
    }

}
