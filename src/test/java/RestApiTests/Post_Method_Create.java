package RestApiTests;

import Utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Post_Method_Create {
    @BeforeClass
    public static void setUp() {

        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
    }

    @Test
    public void Add_NewSpartan_Test() {

        Response response;

        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("id", 486);
        bodyMap.put("name", "Myra");
        bodyMap.put("gender", "Female");
        bodyMap.put("phone", "12189113345");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).when()
                .post("/spartans")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("success", is("A Spartan is Born!"))
                .body("data.name", equalToIgnoringCase("Myra"))
                .body("data.phone", hasToString("12189113345"));   // 201  Created


    //intellijj
    }
}
