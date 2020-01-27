package RestApiTests;

import Utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javafx.beans.binding.When;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class SpartanRestApi_Sunday {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
//        RestAssured.baseURI = ConfigurationReader.get("aws.base_url");


    }

    @Test
    public void All_Spartan_With_Size_And_Items_Test() {
// Specification Part
        given()
                .accept(ContentType.JSON)
   // This part where you send a request and get respond
                .when()
                .get("/spartans").prettyPeek()
                //Validatable respond part // We can use assertion
                .then()
                .statusCode(200)
                .body("phone", hasSize(104)).header("Transfer-Encoding", "chunked")
                 .contentType("application/json;charset=UTF-8")
                 .header("date", notNullValue());

    }

}