package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class SpartanTest_Akbar {

    //  Import -> import static io.restassured.RestAssured.*; -> to make your code simpler

    @BeforeClass
    public static void setUp() {

        // Base URL   http://3.83.88.105:8000/api
        //BASE URI means all API end point share this portion.
        //We dont have to write everything  -- You can give more specific
        RestAssured.baseURI = "http://3.83.190.136";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @Test
    public void Spartan_All_Test() {
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
    public void SingleSpartanData_Test() {

        Response response = get("/spartans/2");
        System.out.println("response.asString() = " + response.asString());
        response.prettyPrint();

        assertEquals("application/json;charset=UTF-8", response.contentType());
        assertEquals(200, response.statusCode());

        // I wanna make sure this name exist
        assert response.asString().contains("Nels");
    }

        @Test
        public void SingleSpartanDataWithHeader_Test () {

        //   Request Specification object hold the info about the request
            //like header, path variable, query parameters, body
            //Response is the object to store Response data

            //   This is how we can path header to the request
           Response response = given()
//                   .header("accept", "application/json")  <-- They are accepting as JSON
                   .accept(ContentType.JSON)    //  <-- They are accepting as JSON
                   .when()
                   .get("/spartan/2");

            assertEquals("application/json;charset=UTF-8", response.contentType());

        }

    @Test
    public void SingleSpartanDataWithHeaderXmlStatusCode_406_Test () {
        //   This is how we can path header to the request
        Response response = given()
//                   .header("accept", "application/json")  <-- They are accepting as JSON
                .accept(ContentType.XML)    //  <-- They are accepting as JSON
                .when()
                .get("/spartans/2");

        //Gives you whole line of Status code
        System.out.println(response.statusLine());
        assertEquals(406, response.statusCode());


        }
        @Test
        public void InvalidSpartanId_ShouldReturn_404_test () {
            Response response =
                    given().pathParam("my_id", 2).when().get("/spartans/{my_id}");
            response.prettyPrint();
            assertEquals("application/json;charset=UTF-8", response.contentType());
            assertEquals(200, response.statusCode());

//            assert response.asString().contains("Spartan Not Found");


    }

    @Test
    public void Search_By_Providing_Query_Parameter(){

        // give some parameters and get male people
        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("gender", "Male")  // you can also use   .param
                .get("/spartans/search");

        assertEquals(200, response.statusCode());
        assertFalse(response.asString().contains("Female"));
        response.prettyPrint();

        System.out.println(response.path("pageable.sort.sorted").toString());

    }

    @Test
    public void SingleSpartanData_Json_FieldValue_Test(){

        Response response=
// Path parameter, you can give any name but declare it inside get
                given().pathParam("kahraman", 2).when().get("/spartans/{kahraman}");
        response.prettyPrint();

              System.out.println(   response.path("name").toString()  );
              System.out.println(   response.path("phone").toString()  );
              assertEquals("Nels", response.path("name").toString());
    }
    }
