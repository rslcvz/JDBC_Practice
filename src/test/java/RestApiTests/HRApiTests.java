package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;

public class HRApiTests {

    //You must declare http format otherwise it wont work
    String regionsUrl = "http://3.83.88.105:1000/ords/hr/regions";
    SoftAssert softAssert = new SoftAssert();

@Test
    public void getAllRegions(){
    Response response = RestAssured.given().accept(ContentType.JSON).when().get(regionsUrl);
    // We are asking status code to verify everything is ok
    System.out.println("The response code is " + response.statusCode());
    System.out.println("The Content Type is " + response.contentType());
        response.body().prettyPrint();

    Assert.assertEquals(200, response.statusCode());
    Assert.assertEquals("application/json", response.contentType());
    Assert.assertTrue(response.body().asString().contains("Americas"));
    Assert.assertTrue(response.body().asString().contains("Europe"));

}
}
