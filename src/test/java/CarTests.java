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
public class CarTests extends Base {
    protected File file = new File("src/test/resources/carData.json");
    protected FileReader fileReader = new FileReader(file);
    protected JSONTokener jsonTokener = new JSONTokener(fileReader) ;
    protected JSONObject jsonObject = new JSONObject (jsonTokener);


    public CarTests() throws FileNotFoundException, JSONException {
    }


    @Test (priority = 1)
    public void test_addCar()  {
        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().post("/CarsMarket");
        Assert.assertEquals(response.getStatusCode(),201);
        response.prettyPrint();



    }
    @Test(priority = 2)
    public  void test_deleteCar_by_id(){
        response = request.delete("/CarsMarket/11");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test(priority = 3)
    public void update_CarData() {

        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().patch("/CarsMarket/10");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }
    @Test(priority = 4)
    public void modify_carData() throws JSONException {

        response = request
                .contentType(ContentType.JSON)
                .body(jsonObject.put("price","600,000 EGP").toString())
                .when().put("/CarsMarket/1");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();

    }
    @Test (priority = 5)
    public void get_CarData() {

        response = request
                .contentType(ContentType.JSON)
                .when().get("/CarsMarket/2");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();
    }

    @Test (priority = 6)
    public void validate_response_CarInfo() {
        response=request.get("/CarsMarket");
        response.then()
                .assertThat().body("[1].brandModel", equalTo("Nissan Qashqai (2013)")).and()
                .assertThat().body("[1].color", equalTo("Brown")).and()
                .assertThat().body("[1].type", equalTo("SUV")).and()
                .assertThat().body("[1].price", equalTo("600,000 EGP")).and()
                .assertThat().body("[1].description",
                        equalTo("Used car in good condition, payment is in cash only")).and()
                .assertThat().body("[1].location", equalTo("Downtown Cairo, Cairo" )).and()
                .assertThat().body("[1].engineCapacity", equalTo("1600")).and()
                .assertThat().body("[1].kilometers", equalTo("100000 to 119999")).and()
                .assertThat().body("[1].availableCarSpareParts.type", equalTo("Front bumper")).and()
                .assertThat().body("[1].availableCarSpareParts.condition", equalTo("New")).and()
                .assertThat().body("[1].availableCarSpareParts.price", equalTo("2,274 EGP"));

        System.out.println(response.getStatusCode());
    }

}

