package com.andrealoisio.mocks;

import com.andrealoisio.services.ScrapeService;
import io.quarkus.logging.Log;
import io.quarkus.test.Mock;
import javax.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class MockScrapeService extends ScrapeService {

    public void scrape() {
        Log.info("Scrape started");
        Log.info("Mocked scraper");
        Log.info("Scrape finished");
    }

}
