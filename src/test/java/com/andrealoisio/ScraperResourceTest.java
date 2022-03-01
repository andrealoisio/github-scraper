package com.andrealoisio;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class ScraperResourceTest {

    @Test
    public void testStartScrapeEndpoint() {
        given()
                .when().get("/scrape")
                .then()
                .statusCode(200)
                .body(is("Scrape process started"));
    }

}