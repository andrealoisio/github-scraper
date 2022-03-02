package com.andrealoisio;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@QuarkusTest
class UserResourceTest {

    @Test
    void getAllUsers() {
        given()
                .when().get("/users")
                .then()
                .body("size()", equalTo(25))
                .body("id", hasItems(24, 25))
                .body("userId", hasItems(82463519, 7031616))
                .statusCode(200)
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    void getUserByUsername() {
        given()
                .when().get("/users/awelawi")
                .then()
                .body("userId", equalTo(73558557))
                .body("login", equalTo("awelawi"))
                .body("nodeId", equalTo("MDQ6VXNlcjczNTU4NTU3"))
                .statusCode(200)
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    void getUserRepositories() {
        given()
                .when().get("/users/awelawi/repositories")
                .then()
                .body("size()", equalTo(1))
                .body("userId", hasItems(73558557))
                .body("fullName", hasItems("awelawi/NYT-MOVIE-APP"))
                .body("nodeId", hasItems("R_kgDOG38FYg"))
                .statusCode(200)
                .statusCode(Response.Status.OK.getStatusCode());
    }
}