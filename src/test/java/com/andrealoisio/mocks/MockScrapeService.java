package com.andrealoisio.mocks;

import com.andrealoisio.entities.User;
import com.andrealoisio.rest.jsonobjects.RepositoryJson;
import com.andrealoisio.rest.jsonobjects.UserJson;
import com.andrealoisio.services.ScrapeService;
import io.quarkus.test.Mock;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@Mock
@ApplicationScoped
public class MockScrapeService extends ScrapeService {

    @Override
    public List<RepositoryJson> getRepositoriesFromApi() {

        var owner1 = new UserJson();
        owner1.setId(1l);
        owner1.setName("John Doe 1");
        owner1.setCompany("Company 1");
        owner1.setLogin("johndoe0000000001");

        var owner2 = new UserJson();
        owner2.setId(2l);
        owner2.setName("John Doe 2");
        owner2.setCompany("Company 2");
        owner2.setLogin("johndoe0000000002");

        var repo1 = new RepositoryJson();
        repo1.setId(1l);
        repo1.setName("name-repo-1");
        repo1.setFullName("user1/repo1");
        repo1.setOwner(owner1);

        var repo2 = new RepositoryJson();
        repo2.setId(2l);
        repo2.setName("name-repo-2");
        repo2.setFullName("user2/repo2");
        repo2.setOwner(owner2);

        return List.of(repo1, repo2);
    }

}
