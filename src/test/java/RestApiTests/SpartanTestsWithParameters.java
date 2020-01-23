package RestApiTests;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpartanTestsWithParameters {

@BeforeClass
    public static void setUp() {

    // Base URL   http://3.83.88.105:8000/api
    //BASE URI means all API end point share this portion.
    //We dont have to write everything  -- You can give more specific
    RestAssured.baseURI = "http://54.164.29.19";
    RestAssured.port = 8000;
    RestAssured.basePath = "/api";

}
    @Test
            public void test(){
        Response response = get("/hello");
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getHeader("content-type"));

}
@Test
    public void helloTest(){

    Response response = get("/hello");
    assertEquals(200, response.statusCode());
    assertEquals("Hello from Sparta", response.asString());
    // rest assured ;ibrary provide multiple method with same meaning
    //like getHeader = header, getContentType=contentType, statusCode = getStatusCode
    assertEquals("text/plain;charset=UTF-8", response.header("content-type"));



}
@Test
    public void Hello_EndPoint_HeaderContains_Test(){

    Response response = get("/hello");
    String headerValue = response.getHeader("Date");
    System.out.println("headerValue = " + headerValue);
    //its giving you the date or null(Both Passing)
    //if its null dont pass, this is how we do it.
    assertNotNull(headerValue);

    assert response.getHeaders().hasHeaderWithName("Date");
    // Get header returns String, you cannt assert with a number.
    assertEquals ("17", response.getHeader("content-length"));


}


}
