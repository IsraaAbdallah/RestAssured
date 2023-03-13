import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class UserTests extends  Base{
    HashMap<String, String> userData  = new HashMap<>();
    @Test(priority = 1)
    public void verifyNoDuplicatedAccounts(){
        HashMap<String, String> userData  = new HashMap<>();
        userData.put("email", "esraa@gmail.com");
        userData.put("password","abc123");
        RestAssured.given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .body(userData)
                .contentType("application/json")
                .when()
                .post("/users/")
                .prettyPrint();
    }
    @Test(priority = 2)
    public void test_signUp(){

        userData.put("email", "hala@gmail.com");
        userData.put("password","car21");
        RestAssured.given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .body(userData)
                .contentType("application/json")
                .when()
                .post("/users/")
                .prettyPrint();
    }
    @Test(priority = 3)
    public void login(){
        RestAssured.authentication=RestAssured.preemptive().basic
                ("sara@mail.com","abc125");
        RestAssured.baseURI="http://localhost:3000";

    }
    @Test(priority = 4)
    public  void test_delete_user(){
        response = request.delete("/users/7");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test(priority = 5)
    public void update_userInfo() {

        response = request
                .contentType(ContentType.JSON)
                .body(userData)
                .when().patch("/users/10");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }

}
