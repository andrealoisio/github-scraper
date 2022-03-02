package com.andrealoisio.services.restclients;

import com.andrealoisio.jsonobjects.UserJson;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserRestClientTest {

    @InjectMock
    @RestClient
    UserRestClient userRestClient;

//    @Test
//    public void testUserRestClient() {
//        var mockedUserJson = new UserJson();
//        mockedUserJson.setLogin("andrealoisio");
//        mockedUserJson.setId(16350390l);
//        mockedUserJson.setUrl("https://api.github.com/users/andrealoisio");
//        Mockito.when(userRestClient.getUser()).thenReturn(new UserJson());
//
//        given()
//                .when().get("/users/octocat")
//                .then()
//                .statusCode(200)
//                .body(is("hello from mockito"));
//    }

}