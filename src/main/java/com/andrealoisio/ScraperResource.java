package com.andrealoisio;

import com.andrealoisio.services.ScrapeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/scrape")
public class ScraperResource {

    @Inject
    ScrapeService scrapeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String startScrape() {
        scrapeService.scrape();
        return "OK";
    }
}
