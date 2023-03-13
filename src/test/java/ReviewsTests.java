import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static org.hamcrest.Matchers.equalTo;

public class ReviewsTests extends Base {


    private File file = new File("src/test/resources/reviewData.json");
    private FileReader fileReader = new FileReader(file);
    private JSONTokener jsonTokener = new JSONTokener(fileReader) ;
    private JSONObject jsonObject = new JSONObject (jsonTokener);

    public ReviewsTests() throws JSONException, FileNotFoundException {
    }


    @Test(priority = 1)
    public void test_addReview()  {
        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().post("/Reviews");
        Assert.assertEquals(response.getStatusCode(),201);
        response.prettyPrint();



    }
    @Test(priority = 2)
    public  void test_deleteReview_by_id(){
        response = request.delete("/Reviews/7");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test(priority = 3)
    public void update_reviewData() {

        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().patch("/Reviews/6");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test (priority = 4)
    public void modify_reviewData() throws JSONException {

        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.put("review","car is good").toString())
                .when().put("/Reviews/5");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test (priority = 5)
    public void get_reviewData() {

        response = request
                .contentType(ContentType.JSON)
                .when().get("/Reviews/4");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();
    }

    @Test(priority = 6)
    public void validate_response_reviewData() {
        response=request.get("/Reviews");
            response.then()
            .assertThat().body("[0].username", equalTo("Esraa")).and()
            .assertThat().body("[0].review",
                    equalTo("the support team is vey helpful"));
        System.out.println(response.getStatusCode());
    }

}
