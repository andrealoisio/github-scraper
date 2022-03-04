package com.andrealoisio;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class RepositoryResourceTest {

    @Test
    void getAllRepositories() {
        given()
                .when().get("/repositories")
                .then()
                .body("size()", equalTo(25))
                .body("id", hasItems(1, 2))
                .body("userId", hasItems(82260676, 16350390))
                .statusCode(200)
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    void searchRepositories() {
        given()
                .when().get("/repositories/user/awelawi")
                .then()
                .body("size()", equalTo(1))
                .body("id", hasItems(11))
                .body("userId", hasItems(73558557))
                .statusCode(200)
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    void searchNonExistentUserRepositories() {
        given()
                .when().get("/repositories/user/aaaaaaaaaaaaaaaaaaaaa")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }

}