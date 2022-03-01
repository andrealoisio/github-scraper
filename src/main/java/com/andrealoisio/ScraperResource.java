package com.andrealoisio;

import com.andrealoisio.services.ScrapeService;
import org.eclipse.microprofile.context.ManagedExecutor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/scrape")
public class ScraperResource {

    @Inject
    ScrapeService scrapeService;

    @Inject
    ManagedExecutor managedExecutor;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String startScrape() {
        managedExecutor.submit(() -> {
            scrapeService.scrape();
        });
        return "Scrape process started";
    }
}
