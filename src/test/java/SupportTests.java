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

public class SupportTests extends Base {



    private final File file = new File("src/test/resources/supportData.json");
    private final FileReader fileReader = new FileReader(file);
    private final JSONTokener jsonTokener = new JSONTokener(fileReader) ;
    private final JSONObject jsonObject = new JSONObject (jsonTokener);
    public SupportTests() throws FileNotFoundException, JSONException {
    }


    @Test(priority = 1)
    public void test_addSupportMember()  {
        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().post("/SupportTeam");
        Assert.assertEquals(response.getStatusCode(),201);
        response.prettyPrint();



    }
    @Test(priority = 2)
    public  void test_deleteSupportMember_by_id(){
        response = request.delete("/SupportTeam/3");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test(priority = 3)
    public void update_SupportMemberData() {

        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().patch("/SupportTeam/2");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test (priority = 4)
    public void modify_supportMemberInfo() throws JSONException {

        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.put("firstName","Nada").toString())
                 .when().put("/SupportTeam/2");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test (priority = 5)
    public void get_SupportData() {

        response = request
                .contentType(ContentType.JSON)
                .when().get("/SupportTeam/1");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();
    }

    @Test(priority = 6)
    public void validate_response_reviewData() {
        response=request.get("/SupportTeam");
        response.then()
                .assertThat().body("[0].firstName", equalTo("Ahmed")).and()
                .assertThat().body("[0].lastName", equalTo("Mohamadi"));
        System.out.println(response.getStatusCode());
    }

}
