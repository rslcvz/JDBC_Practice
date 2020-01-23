package RestApiTests;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpartanTestsWithParameters {

@BeforeClass
    public static void setUp(){

    // Base URL   http://3.83.88.105:8000/api
    //BASE URI means all API end point share this portion.
    //We dont have to write everything
    RestAssured.baseURI = "http://3.83.88.105:1000/ords/hr/regions/6";
    //3.83.88.105:1000/ords/hr/regions/6
}
@Test
    public void helloTest(){
            Response response = get("http://54.164.29.19:8000/api/hello");
    System.out.println("response.statusCode() = " + response.statusCode());
    System.out.println(response.asString());
    System.out.println(response.getHeader("content-type"));
    assertEquals(200, response.statusCode());
    assertEquals("Hello from Sparta", response.asString());
    // rest assured ;ibrary provide multiple method with same meaning
    //like getHeader = header, getContentType=contentType, statusCode = getStatusCode
    assertEquals("text/plain;charset=UTF-8", response.header("content-type"));



}
//@Test
//    public void

}
