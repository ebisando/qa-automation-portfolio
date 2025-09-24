import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class UserAPITest {

    @Test
    public void testGetUsers() {
        RestAssured.get("https://jsonplaceholder.typicode.com/users")
                   .then()
                   .statusCode(200)
                   .body("size()", greaterThan(0));
    }

    @Test
    public void testCreatePost() {
        String payload = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        RestAssured.given()
                   .header("Content-type", "application/json")
                   .body(payload)
                   .post("https://jsonplaceholder.typicode.com/posts")
                   .then()
                   .statusCode(201)
                   .body("title", equalTo("foo"));
    }
}
