package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SpartanTest_Akbar {

    //  Import -> import static io.restassured.RestAssured.*; -> to make your code simpler

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
    public void Spartan_All_Test(){
        Response response = get("/spartans/");
        // to get status code
        assertEquals(200, response.statusCode());
        // to get content type --> These are all same
        assertEquals("application/json;charset=UTF-8", response.contentType());
        assertEquals("application/json;charset=UTF-8", response.getContentType());
        assertEquals("application/json;charset=UTF-8", response.getHeader("content-type"));

        //checking whether one header exists
        boolean hasDataHeader = response.getHeaders().hasHeaderWithName("date");
        assertTrue(hasDataHeader);


    }
    @Test
    public void SingleSpartanData_Test(){
        
        Response response = get("/spartans/2");
        System.out.println("response.asString() = " + response.asString());
        response.prettyPrint();

        assertEquals("application/json;charset=UTF-8", response.contentType());
        assertEquals(200, response.statusCode());

        // I wanna make sure this name exist
        assert response.asString().contains("Nels");

    }
    @Test
    public void InvalidSpartanId_ShouldReturn_404_test(){
        Response response = get("/spartans/2");
        response.prettyPrint();
        assertEquals("application/json;charset=UTF-8", response.contentType());
        assertEquals(200, response.statusCode());

        assert response.asString().contains("Nels");
    }
}