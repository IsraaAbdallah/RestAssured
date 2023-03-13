import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class Authentication extends Base {
    @Test
    public void testKeyAuthentication() {

        RestAssured .given().baseUri("http://localhost:3000")
                .header("key","$2a$10$b8thbYNrqewIQ/69e9rw0.G8Q9Ji.i9CPYOqBEqhYfjvbm2neweCm")
                .when()
                .get ("/users")
                .then()
                .assertThat().statusCode(200);

    }
    @Test
    public void testAPIKeyAuthentication () {
        response=  request.given()
                .queryParam ("apiKey", "$2a$10$TFsM/oiMibEYr1tKc6Ehd.Ma5WlpU83TfP/iEWVAyud9lWuGyT/3i")
                .queryParam ("id", 3)
                .get("/Reviews");
        response .prettyPrint();
    }
    @Test
    public void testBasicAuthentication () {

      response=  request.given()
                .auth().basic("esraa@gmail.com","abc123").get("/users/1");
              response .prettyPrint();
    }

}

