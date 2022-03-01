package com.andrealoisio.services;

import com.andrealoisio.entity.Repository;
import com.andrealoisio.entity.User;
import com.andrealoisio.jsonobjects.RepositoryJson;
import com.andrealoisio.repositories.RepositoryRepository;
import com.andrealoisio.repositories.ScraperInfoRepository;
import com.andrealoisio.repositories.UserRepository;
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
    UserRepository userRepository;

    @Inject
    ScraperInfoRepository scraperInfoRepository;

    @ConfigProperty(name = "scraper.repository.repos-to-persist")
    Integer numberOfReposToPersist;

    @ConfigProperty(name = "scraper.repository.start-id")
    Long repositoryStartId;

    public void scrape() {
        Log.info("Scrape started");

        var repositoryList = repositoryRestClient.getRepositoriesSince(getRepositoryStartId());

        var chunks = Lists.partition(repositoryList, numberOfReposToPersist);

        for (List<RepositoryJson> chunk : chunks) {
            persistChunk(chunk);
        }

        Log.info("Scrape finished");
    }

    @Transactional
    void persistChunk(List<RepositoryJson> repositoryList) {

        var users = getUsersEntities(repositoryList);
        userRepository.persist(getNonExistingUsers(users));

        var repositories = getRepositoriesEntities(repositoryList);
        repositoryRepository.persist(repositories);

        var lastRepo = repositories.get(repositories.size() - 1);
        var scraperInfo = scraperInfoRepository.findById(1l);

        scraperInfo.setLastRepoId(lastRepo.getRepositoryIdId());
        scraperInfoRepository.persist(scraperInfo);
    }

    private List<Repository> getRepositoriesEntities(List<RepositoryJson> jsonRepositories) {
        return jsonRepositories.stream().map(RepositoryJson::toEntity).collect(Collectors.toList());
    }

    private List<User> getUsersEntities(List<RepositoryJson> jsonRepositories) {
        return jsonRepositories.stream().map(item -> item.getOwner().toEntity()).collect(Collectors.toList());
    }

    private List<Long> getUsersIds(List<User> users) {
        return users.stream().map(User::getUserId).collect(Collectors.toList());
    }

    private List<User> getNonExistingUsers(List<User> users) {
        var existingUserIds = userRepository.findByUserId(getUsersIds(users))
                .stream()
                .map(User::getUserId)
                .collect(Collectors.toList());
        return users.stream().filter(user -> !existingUserIds.contains(user.getUserId())).collect(Collectors.toList());
    }

    private Long getRepositoryStartId() {
        var scraperInfo = scraperInfoRepository.findById(1l);
        if (scraperInfo.getLastRepoId() > 0) {
            return scraperInfo.getLastRepoId();
        }
        return repositoryStartId;
    }

}
