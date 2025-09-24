import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class apitest {

    @Test
    public void testGetPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
            .when()
            .get("/posts/1")
            .then()
            .statusCode(200)
            .body("userId", equalTo(1))
            .body("id", equalTo(1))
            .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void testCreatePost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

String jsonBody = "{\n" +
                  "    \"title\": \"foo\",\n" +
                  "    \"body\": \"bar\",\n" +
                  "    \"userId\": 1\n" +
                  "}";

        Response response = given()
            .header("Content-type", "application/json")
            .and()
            .body(jsonBody)
            .when()
            .post("/posts")
            .then()
            .statusCode(201)
            .extract().response();

        System.out.println("Response: " + response.asString());
    }
}

