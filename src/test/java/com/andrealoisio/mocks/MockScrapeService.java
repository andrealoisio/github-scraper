package com.andrealoisio.mocks;

import com.andrealoisio.rest.jsonobjects.RepositoryJson;
import com.andrealoisio.services.ScrapeService;
import io.quarkus.test.Mock;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@Mock
@ApplicationScoped
public class MockScrapeService extends ScrapeService {

    /* public void scrape() {
        Log.info("Scrape started");
        Log.info("Mocked scraper");
        Log.info("Scrape finished");
    } */

    @Override
    public List<RepositoryJson> getRepositoriesFromApi() {
        return new ArrayList<>();
    }

}
