package com.andrealoisio.services.restclients;

import com.andrealoisio.rest.client.UserRestClient;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

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