import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class Authentication extends Base {
    @Test
    public void testKeyAuthentication() {

        RestAssured .given().spec(request)
                .header("key","$2a$10$b8thbYNrqewIQ/69e9rw0.G8Q9Ji.i9CPYOqBEqhYfjvbm2neweCm")
                .when()
                .get ("/users")
                .then()
                .assertThat().statusCode(200);

    }
    @Test
    public void testAPIKeyAuthentication () {
        RestAssured .given().spec(request)
                .queryParam ("apiKey", "$2a$10$TFsM/oiMibEYr1tKc6Ehd.Ma5WlpU83TfP/iEWVAyud9lWuGyT/3i")
                .queryParam ("id", 3)
                .get("/Reviews")
                .prettyPrint();
    }
    @Test
    public void testBasicAuthentication () {

      RestAssured .given().spec(request)
                .auth().basic("esraa@gmail.com","abc123").get("/users/1")
                .prettyPrint();
    }

}

