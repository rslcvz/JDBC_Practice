package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class SpartanRest_Weekend {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://54.164.29.19";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @Test
    public void test1() {

        // Request Specification

        Response response =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/spartans/2");
        response.prettyPrint();
        Assert.assertEquals("Male", response.path("gender").toString());
    }

    @Test
    public void Search_By_Providing_Query_Parameter() {

        // give some parameters and get male people
        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("gender", "Male")  // you can also use   .param
                .get("/spartans/search");

        assertEquals(200, response.statusCode());
        assertFalse(response.asString().contains("Female"));
        response.prettyPrint();

        System.out.println(response.path("pageable.sort.empty").toString());

        //json path  --> just like xpath, its for finding elements in json object/ document.

        boolean isEmpty = response.jsonPath().getBoolean("pageable.sort.empty");
        Assert.assertTrue(isEmpty);

        int totalElements = response.jsonPath().getInt("totalPages");
        System.out.println("totalPages  = " + totalElements);

        // find out totalElement field from the response, number of elements


    }

    @Test
    public void Search_By_Providing_JsonPath_Practice_For_Array() {

        // give some parameters and get male people
        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("gender", "Male")  // you can also use   .param
                .get("/spartans/search");

        assertEquals(200, response.statusCode());
        assertFalse(response.asString().contains("Female"));
        response.prettyPrint();
        //Lets get the first person's phone number
        long firstPhone = response.jsonPath().getLong("content[0].phone");
        System.out.println("firstPhone = " + firstPhone);

        //Gets all phone numbers
        List<String> phoneList = response.jsonPath().getList("content.phone");
        System.out.println("phoneList = " + phoneList);

        // You can get couple of numbers ( but not one in a List)
        List<String> phoneList1 = response.jsonPath().getList("content[0, 1, 2].phone");
        System.out.println("phoneList1 = " + phoneList1);

        //Get names
        List<String> getNames = response.jsonPath().getList("content.name");
        System.out.println("Get Names = " + getNames);



    }
}