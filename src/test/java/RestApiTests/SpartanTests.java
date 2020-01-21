package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpartanTests {

    String spartanAllURL = "http://3.83.88.105:8000/api/spartans/";

    @Test
    public void viewAllSpartansTest() {
        Response response = RestAssured.get(spartanAllURL);
        System.out.println("Success");
        System.out.println(response.statusCode());
//        System.out.println(response.body().asString());
        response.body().prettyPrint();
    }
    /*
    Given accept type is JSon
    When user sends a get request to spartanAllURL
    Then response status code is 200
    And response body should json
    And response should contain "name": "Chipotle"
     */

    @Test
    public void viewAllSpartansTest2() {
        //How did I get to Spartans
        //http://3.83.88.105:8000/      using my Ip and 8000 than there are spartans :)  (from Batch 11)

//        Response response = RestAssured.get(spartanAllURL);
        Response response = RestAssured.given().accept(ContentType.JSON).when().get(spartanAllURL);

        // Status Code must be 200 means Ok
        assertEquals(200, response.statusCode());
        assertEquals("application/json;charset=UTF-8", response.contentType());
        Assert.assertTrue(response.body().asString().contains("Fidole"));
    }

    @Test
    public void viewAllSpartansTest3() {

              // request part
                 given().accept(ContentType.JSON)
                .when().get(spartanAllURL)
                  //  response part
                .then().statusCode(200)
                .and().contentType("application/json;charset=UTF-8");
    }
    /*
    When users sends a get request to/ spartans/3
    Then status code should be 200
    And content type should be application/json;charset=UTF-8
    And json body should contain Fidole
     */

       @Test
    public void getASpartanTest(){

           Response response = when().get(spartanAllURL + 4);
           assertEquals(200, response.statusCode());
           assertEquals("application/json;charset=UTF-8", response.contentType());
           assertTrue(response.body().asString().contains("Paige"));
       }

}