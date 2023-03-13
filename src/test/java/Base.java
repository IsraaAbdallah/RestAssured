import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;


public class Base {

    protected   RequestSpecification request;
    protected  Response response;


    @BeforeTest
    public void base()  {
        request = RestAssured.given().baseUri("http://localhost:3000");
    }




}
